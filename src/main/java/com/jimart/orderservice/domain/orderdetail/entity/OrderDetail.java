package com.jimart.orderservice.domain.orderdetail.entity;

import com.jimart.orderservice.domain.order.common.BaseEntity;
import com.jimart.orderservice.domain.order.entity.Orders;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_detail_id")
    private Long id;

    private String productCd;

    private String productName;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;

    // 연관관계 편의 메소드 (OrdersDetail <-> Orders)
    public void setOrders(Orders order) {
        if (this.orders != null) {
            this.orders.getOrdersDetails().remove(this);
        }

        this.orders = order;
        orders.getOrdersDetails().add(this);
    }

}