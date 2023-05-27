package com.jimart.orderservice.domain.order.dto;

import com.jimart.orderservice.domain.order.entity.Orders;
import com.jimart.orderservice.domain.orderdetail.entity.OrderDetail;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderResDto {

    private Long id;
    private int totalPrice;
    private LocalDateTime registeredDateTime;
    private List<Long> productIds;

    @Builder
    private OrderResDto(Long id, int totalPrice, LocalDateTime registeredDateTime, List<Long> productIds) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.registeredDateTime = registeredDateTime;
        this.productIds = productIds;
    }

    public static OrderResDto of(Orders order) {
        return OrderResDto.builder()
                .id(order.getId())
                .totalPrice(order.getTotalPrice())
                .registeredDateTime(order.getCreatedDateTime())
                .productIds(order.getOrdersDetails().stream()
                        .map(OrderDetail::getProductId)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
