package com.test.food_delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.food_delivery.entity.Orders;
import com.test.food_delivery.interfaces.TopOrder;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
     @Query(value = """
            SELECT
                o.id AS orderId,
                o.customer_name AS customerName,
                o.total_price AS totalPrice,
                SUM(oi.quantity) AS totalItems
            FROM orders o
            JOIN order_item oi
                ON o.id = oi.order_id
            GROUP BY
                o.id,
                o.customer_name,
                o.total_price
            ORDER BY o.total_price DESC
            LIMIT 5
            """, nativeQuery = true)
    List<TopOrder> findTop5HighestOrders();
}
