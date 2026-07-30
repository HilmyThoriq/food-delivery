package com.test.food_delivery.dto.restaurantDTO;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantResponseDTO {

    private Long id;

    private String name;

    private String address;

    private LocalDateTime createdAt;
}
