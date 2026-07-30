package com.test.food_delivery.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.test.food_delivery.dto.OrderItemRequestDTO;
import com.test.food_delivery.dto.OrderRequestDTO;
import com.test.food_delivery.dto.TopOrderDTO;
import com.test.food_delivery.entity.Menu;
import com.test.food_delivery.entity.OrderItem;
import com.test.food_delivery.entity.Orders;
import com.test.food_delivery.repository.MenuRepository;
import com.test.food_delivery.repository.OrderItemRepository;
import com.test.food_delivery.repository.OrdersRepository;
import com.test.food_delivery.service.OrderService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MenuRepository menuRepository;
    private final OrdersRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    @Override
    public Orders createOrder(OrderRequestDTO request) {

        BigDecimal total = BigDecimal.ZERO;

        Orders order = new Orders();
        order.setCustomerName(request.getCustomerName());
        order.setRestaurantId(request.getRestaurantId());
        order = orderRepository.save(order);

        for (OrderItemRequestDTO item : request.getItems()) {
            OrderItem orderItem = new OrderItem();
            Menu menu = menuRepository.findById(item.getMenuId())
                    .orElseThrow(() -> new RuntimeException("Menu not found"));

            orderItem.setMenuId(item.getMenuId());
            orderItem.setOrderId(order.getId());
            orderItem.setPrice(menu.getPrice());
            orderItem.setQuantity(item.getQuantity());
            orderItemRepository.save(orderItem);

            total = total.add(
                    menu.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        order.setTotalPrice(total);
        orderRepository.save(order);

        return order;
    }

    @Override
    public List<TopOrderDTO> getTop5HighestOrders() {

        AtomicInteger rank = new AtomicInteger(1);

        return orderRepository.findTop5HighestOrders()
                .stream()
                .map(order -> new TopOrderDTO(
                        rank.getAndIncrement(),
                        order.getOrderId(),
                        order.getCustomerName(),
                        order.getTotalPrice(),
                        order.getTotalItems()))
                .toList();
    }
}
