package com.test.food_delivery.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopOrderDTO {

    private Integer rank;
    private Long orderId;
    private String customerName;
    private BigDecimal totalPrice;
    private Integer totalItems;
}