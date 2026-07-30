package com.test.food_delivery.service;

import java.util.List;

import com.test.food_delivery.dto.menuDTO.SearchMenuResponseDTO;
import com.test.food_delivery.entity.Menu;

public interface MenuService {

    List<Menu> getMenusByRestaurant(Long restaurantId);
    List<SearchMenuResponseDTO> searchMenu(String keyword);
}