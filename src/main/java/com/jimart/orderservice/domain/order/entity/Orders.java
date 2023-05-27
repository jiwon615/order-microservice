package com.jimart.orderservice.domain.order.entity;

import com.jimart.orderservice.domain.order.common.BaseEntity;
import com.jimart.orderservice.domain.order.constant.OrderStatus;
import com.jimart.orderservice.domain.orderdetail.entity.OrderDetail;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "jimart_order")
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private int totalPrice;

    @Column(nullable = false, unique = true)
    private String userId;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> ordersDetails = new ArrayList<>();
}
