package com.test.food_delivery.service;

import java.math.BigDecimal;
import java.util.List;

import com.test.food_delivery.dto.OrderRequestDTO;
import com.test.food_delivery.dto.TopOrderDTO;
import com.test.food_delivery.entity.Orders;

public interface OrderService {

    Orders createOrder(OrderRequestDTO request);
    List<TopOrderDTO> getTop5HighestOrders();
}
