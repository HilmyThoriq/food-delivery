package com.test.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.food_delivery.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
