package com.jimart.orderservice.domain.order.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDto {

    private Long orderId;
    private int totalPrice;
    private String userId;
    private List<Long> productIds;

    @Builder
    private OrderDto(Long orderId, int totalPrice, String userId, List<Long> productIds) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.productIds = productIds;
    }
}
