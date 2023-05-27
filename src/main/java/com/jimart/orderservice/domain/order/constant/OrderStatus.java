package com.jimart.orderservice.domain.order.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    PAYMENT_COMPLETED("PAY_COMP", "결제 완료"),
    PAYMENT_FAILED("PAY_FAIL", "결제 실패"),
    CANCELED("CANCELED", "주문 취소"),
    DELIVERY("DELIVERY", "배송중"),
    COMPLETED("COMPLETED", "처리 완료")
    ;

    private final String code;
    private final String text;
}