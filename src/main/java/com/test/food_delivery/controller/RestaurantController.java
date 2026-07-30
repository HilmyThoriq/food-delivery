package com.test.food_delivery.controller;

import com.test.food_delivery.dto.restaurantDTO.RestaurantRequestDTO;
import com.test.food_delivery.dto.restaurantDTO.RestaurantResponseDTO;
import com.test.food_delivery.entity.Menu;
import com.test.food_delivery.entity.Restaurant;
import com.test.food_delivery.service.MenuService;
import com.test.food_delivery.service.RestaurantService;
import com.test.food_delivery.util.ApiResponse;
import com.test.food_delivery.util.ResponseUtil;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final MenuService menuService;
    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Restaurant>>> getAllRestaurants() {

        try {

            List<Restaurant> restaurants = restaurantService.getAllRestaurants();

            return ResponseUtil.success(
                    "Restaurants retrieved successfully",
                    restaurants);

        } catch (Exception e) {

            return ResponseUtil.error(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());

        }
    }

    @GetMapping("/{id}/menus")
    public ResponseEntity<ApiResponse<List<Menu>>> getMenus(
            @PathVariable Long id) {

        try {

            return ResponseUtil.success(
                    "Menus retrieved successfully",
                    menuService.getMenusByRestaurant(id));

        } catch (Exception e) {

            return ResponseUtil.error(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());

        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<RestaurantResponseDTO>> create(
            @Valid @RequestBody RestaurantRequestDTO request) {

        try {

            return ResponseUtil.success(
                    "Restaurant created successfully",
                    restaurantService.create(request));

        } catch (Exception e) {

            return ResponseUtil.error(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<RestaurantResponseDTO>> update(
            @PathVariable Long id,
            @Valid @RequestBody RestaurantRequestDTO request) {

        try {

            return ResponseUtil.success(
                    "Restaurant updated successfully",
                    restaurantService.update(id, request));

        } catch (Exception e) {

            return ResponseUtil.error(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable Long id) {

        try {

            restaurantService.delete(id);

            return ResponseUtil.success(
                    "Restaurant deleted successfully",
                    null);

        } catch (Exception e) {

            return ResponseUtil.error(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage());

        }
    }
}