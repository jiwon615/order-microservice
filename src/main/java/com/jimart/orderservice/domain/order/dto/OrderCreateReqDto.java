package com.jimart.orderservice.domain.order.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderCreateReqDto {


    public OrderDto toOrderDto() {
        return OrderDto.builder()
                .build();
    }
}
