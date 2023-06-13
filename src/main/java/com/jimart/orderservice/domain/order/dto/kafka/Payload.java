package com.jimart.orderservice.domain.order.dto.kafka;

import com.jimart.orderservice.domain.orderdetail.entity.OrderDetail;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Payload {
    private Long orderId;
    private String orderStatus;
    private int totalPrice;
    private String userId;
    private List<OrderDetail> ordersDetails;

    @Builder
    private Payload(String orderStatus, int totalPrice, String userId, List<OrderDetail> ordersDetails) {
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.ordersDetails = ordersDetails;
    }
}
