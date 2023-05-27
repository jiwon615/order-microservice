package com.jimart.orderservice.domain.order.service;

import com.jimart.orderservice.core.exception.CustomException;
import com.jimart.orderservice.domain.order.dto.OrderDto;
import com.jimart.orderservice.domain.order.dto.OrderResDto;
import com.jimart.orderservice.domain.order.entity.Orders;
import com.jimart.orderservice.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jimart.orderservice.core.exception.ErrorMsgType.ORD_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public OrderResDto createOrder(OrderDto request) {

        return null;
    }

    @Override
    public OrderResDto getOrderByOrderId(OrderDto request) {
        Optional<Orders> orderOpt = orderRepository.findById(request.getOrderId());
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
}
