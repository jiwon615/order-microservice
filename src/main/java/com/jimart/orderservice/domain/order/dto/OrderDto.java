package com.jimart.orderservice.domain.order.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDto {

    private String test;

    @Builder
    private OrderDto(String test) {
        this.test = test;
    }
}
