package com.jimart.orderservice.domain.order.service;

import com.jimart.orderservice.core.exception.CustomException;
import com.jimart.orderservice.core.messagequeue.KafkaProducer;
import com.jimart.orderservice.domain.order.client.ProductServiceClient;
import com.jimart.orderservice.domain.order.constant.OrderStatus;
import com.jimart.orderservice.domain.order.dto.OrderDto;
import com.jimart.orderservice.domain.order.dto.OrderResDto;
import com.jimart.orderservice.domain.order.entity.Orders;
import com.jimart.orderservice.domain.order.repository.OrderRepository;
import com.jimart.orderservice.domain.orderdetail.entity.OrderDetail;
import com.jimart.orderservice.domain.orderdetail.repository.OrderDetailRepository;
import com.jimart.orderservice.domain.product.dto.ProductResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jimart.orderservice.core.exception.ErrorMsgType.ORD_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final KafkaProducer kafkaProducer;
    private final ProductServiceClient productServiceClient;

    @Override
    public OrderResDto createOrder(OrderDto request) {
        // TODO: 임시 주문 구현 로직 (추후 재고 차감 및 동시성 이슈 해결 로직 추가)
        List<Long> productIds = request.getProductIds();

        Orders order = Orders.builder()
                .orderStatus(OrderStatus.PAYMENT_COMPLETED)
                .ordersDetails(new ArrayList<>())
                .userId(request.getUserId())
                .build();
        Orders savedOrder = orderRepository.save(order);
        int totalPrice = 0;
        for (Long id : productIds) {
            OrderDetail detailForTargetProduct = OrderDetail.builder()
                    .productId(id)
                    .build();
            detailForTargetProduct.setOrders(savedOrder); // 연관관계 편의 메소드
            orderDetailRepository.save(detailForTargetProduct);
            totalPrice += getProductPrice(id);
        }

        savedOrder.setTotalPrice(totalPrice);

        // 재고 감소를 위해 kafka에 주문  상품들을 보냄
        kafkaProducer.send("example-product-topic", productIds);
        return OrderResDto.of(savedOrder);
    }

    private int getProductPrice(Long id) {
        ProductResDto product = productServiceClient.getProductById(id).getData();
        return product.getPrice();
    }

    @Override
    public OrderResDto getOrderByOrderId(Long orderId) {
        Optional<Orders> orderOpt = orderRepository.findById(orderId);
        return orderOpt.map(OrderResDto::of)
                .orElseThrow(() -> new CustomException(ORD_NOT_FOUND)
                );
    }

    @Override
    public List<OrderResDto> getOrdersByUserId(String userId) {
        List<Orders> findOrders = orderRepository.findOrdersByUserId(userId);
        return findOrders.stream()
                .map(OrderResDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResDto> findAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderResDto::of)
                .collect(Collectors.toList());
    }
}
