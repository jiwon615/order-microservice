package com.jimart.orderservice.domain.order.repository;

import com.jimart.orderservice.domain.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findOrdersByUserId(String userId);
}
