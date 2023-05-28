package com.jimart.orderservice.domain.orderdetail.entity;

import com.jimart.orderservice.domain.order.common.BaseEntity;
import com.jimart.orderservice.domain.order.entity.Orders;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "jimart_order_detail")
public class OrderDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_detail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;

    @Column(nullable = false)
    private Long productId;

    // 연관관계 편의 메소드 (OrdersDetail <-> Orders)
    public void setOrders(Orders order) {
        if (this.orders != null) {
            order.getOrdersDetails().remove(this);
        }

        this.orders = order;
        order.getOrdersDetails().add(this);
    }

    @Builder
    private OrderDetail(Orders orders, Long productId) {
        this.orders = orders;
        this.productId = productId;
    }
}