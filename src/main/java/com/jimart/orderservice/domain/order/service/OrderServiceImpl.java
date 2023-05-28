package com.jimart.orderservice.domain.order.service;

import com.jimart.orderservice.core.exception.CustomException;
import com.jimart.orderservice.domain.order.constant.OrderStatus;
import com.jimart.orderservice.domain.order.dto.OrderDto;
import com.jimart.orderservice.domain.order.dto.OrderResDto;
import com.jimart.orderservice.domain.order.entity.Orders;
import com.jimart.orderservice.domain.order.repository.OrderRepository;
import com.jimart.orderservice.domain.orderdetail.entity.OrderDetail;
import com.jimart.orderservice.domain.orderdetail.repository.OrderDetailRepository;
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

    @Override
    public OrderResDto createOrder(OrderDto request) {
        // TODO: 임시 주문 구현 로직 (추후 재고 차감 및 동시성 이슈 해결 로직 추가)
        List<Long> productIds = request.getProductIds();

        int totalPrice = 100000; // TODO: 임시 값 (kafka / RabiitMQ 같은 메시징 시스템으로 상품 데이터를 불러와, 가격을 꽂아주기)
        Orders order = Orders.builder()
                .orderStatus(OrderStatus.PAYMENT_COMPLETED)
                .ordersDetails(new ArrayList<>())
                .userId(request.getUserId())
                .build();
        Orders savedOrder = orderRepository.save(order);
        for (Long id : productIds) {
            OrderDetail detailForTargetProduct = OrderDetail.builder()
                    .productId(id)
                    .build();
            totalPrice += 20000;
            detailForTargetProduct.setOrders(savedOrder); // 연관관계 편의 메소드
            orderDetailRepository.save(detailForTargetProduct);
            totalPrice += 20000;
        }

        savedOrder.setTotalPrice(totalPrice);
        return OrderResDto.of(savedOrder);
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
