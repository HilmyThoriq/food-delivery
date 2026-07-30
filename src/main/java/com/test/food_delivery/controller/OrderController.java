package com.test.food_delivery.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.food_delivery.dto.OrderRequestDTO;
import com.test.food_delivery.dto.TopOrderDTO;
import com.test.food_delivery.entity.Orders;
import com.test.food_delivery.service.OrderService;
import com.test.food_delivery.util.ApiResponse;
import com.test.food_delivery.util.ResponseUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/topFive")
    public ResponseEntity<ApiResponse<List<TopOrderDTO>>> getTopFiveOrders() {

        try {

            List<TopOrderDTO> topOrders = orderService.getTop5HighestOrders();

            return ResponseUtil.success(
                    "Top five orders retrieved successfully",
                    topOrders
            );

        } catch (Exception e) {

            return ResponseUtil.error(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );

        }
    }

    @PostMapping("/createOrder")
    public ResponseEntity<ApiResponse<Orders>> createOrder(
            @RequestBody OrderRequestDTO request) {

        try {

            Orders order = orderService.createOrder(request);

            return ResponseUtil.created(
                    "Order created successfully",
                    order
            );

        } catch (Exception e) {

            return ResponseUtil.error(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );

        }
    }
}
