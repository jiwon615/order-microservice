package com.jimart.orderservice.domain.product.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResDto {
    private Long id;
    private String categoryCode;
    private String status;
    private String name;
    private int price;
    private int quantity;
    private LocalDateTime createdDateTime;
}
