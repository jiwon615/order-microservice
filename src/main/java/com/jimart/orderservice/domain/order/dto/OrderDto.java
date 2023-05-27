package com.jimart.orderservice.domain.order.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDto {

    private Long orderId;
    private int totalPrice;
    private String userId;
    private Long productId;

    @Builder
    private OrderDto(Long orderId, int totalPrice, String userId, Long productId) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.productId = productId;
    }
}
