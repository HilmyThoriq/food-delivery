package com.test.food_delivery.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
public class OrderRequestDTO {

    private String customerName;

    private List<OrderItemRequestDTO> items;

    private Long restaurantId;


}
