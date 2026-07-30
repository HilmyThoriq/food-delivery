package com.test.food_delivery.dto;

import lombok.*;

@Getter
@Setter
public class OrderItemRequestDTO {

    private Long menuId;

    private Integer quantity;

}
