package com.test.food_delivery.dto.menuDTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchMenuResponseDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String restaurantName;
}
