package com.jimart.orderservice.domain.order.controller;

import com.jimart.orderservice.core.common.ApiResponse;
import com.jimart.orderservice.domain.order.dto.OrderCreateReqDto;
import com.jimart.orderservice.domain.order.dto.OrderResDto;
import com.jimart.orderservice.domain.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-service/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public ApiResponse<OrderResDto> createOrder(@RequestBody @Valid OrderCreateReqDto request) {
        return ApiResponse.created(orderService.createOrder(request.toOrderDto()));
    }

    @GetMapping("{userId}")
    public ApiResponse<List<OrderResDto>> getOrdersByUserId(@PathVariable(name = "userId") String userId) {
        return ApiResponse.ok(orderService.getOrdersByUserId(userId));
    }
}
