package com.test.food_delivery.service.impl;

import com.test.food_delivery.dto.restaurantDTO.RestaurantRequestDTO;
import com.test.food_delivery.dto.restaurantDTO.RestaurantResponseDTO;
import com.test.food_delivery.entity.Restaurant;
import com.test.food_delivery.repository.RestaurantRepository;
import com.test.food_delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public RestaurantResponseDTO getById(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        return RestaurantResponseDTO.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }

    @Override
    public RestaurantResponseDTO create(RestaurantRequestDTO request) {

        Restaurant restaurant = new Restaurant();

        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        

        restaurant = restaurantRepository.save(restaurant);

        return RestaurantResponseDTO.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }

    @Override
    public RestaurantResponseDTO update(Long id,
            RestaurantRequestDTO request) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());

        restaurantRepository.save(restaurant);

        return RestaurantResponseDTO.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }

    @Override
    public void delete(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        restaurantRepository.delete(restaurant);
    }
}