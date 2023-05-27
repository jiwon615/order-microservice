package com.jimart.orderservice.domain.order.service;

import com.jimart.orderservice.domain.order.dto.OrderDto;
import com.jimart.orderservice.domain.order.dto.OrderResDto;

import java.util.List;

public interface OrderService {

    OrderResDto createOrder(OrderDto orderDto);

    OrderResDto getOrderByOrderId(OrderDto orderDto);

    List<OrderResDto> getOrdersByUserId(String userId);
}
