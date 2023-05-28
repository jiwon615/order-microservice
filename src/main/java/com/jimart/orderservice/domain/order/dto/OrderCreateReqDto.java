package com.jimart.orderservice.domain.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderCreateReqDto {

    @NotBlank(message = "사용자 ID는 필수값입니다.")
    private String userId;

    @NotEmpty(message = "최소 1개 이상의 상품 아이디가 필요합니다.")
    private List<Long> productIds;

    public OrderDto toOrderDto() {
        return OrderDto.builder()
                .userId(userId)
                .productIds(productIds)
                .build();
    }
}
