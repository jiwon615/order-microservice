package com.jimart.orderservice.domain.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderControllerTest {

    private final Environment env;

    @GetMapping("/health_check")
    public String status() {
        return String.format("Order Service is Working on PORT %s", env.getProperty("local.server.port"));
    }
}
