package com.jimart.orderservice.domain.order.service;

import com.jimart.orderservice.domain.order.dto.OrderDto;
import com.jimart.orderservice.domain.order.dto.OrderResDto;
import com.jimart.orderservice.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public OrderResDto createOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public List<OrderResDto> getOrdersByUserId(String userId) {
        return null;
    }
}
