package com.test.food_delivery.service;

import com.test.food_delivery.dto.restaurantDTO.RestaurantRequestDTO;
import com.test.food_delivery.dto.restaurantDTO.RestaurantResponseDTO;
import com.test.food_delivery.entity.Restaurant;
import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    RestaurantResponseDTO create(RestaurantRequestDTO request);
    RestaurantResponseDTO getById(Long id);
    RestaurantResponseDTO update(Long id, RestaurantRequestDTO request);
    void delete(Long id);

}
