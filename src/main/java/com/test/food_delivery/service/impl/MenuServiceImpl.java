package com.test.food_delivery.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.food_delivery.dto.menuDTO.SearchMenuResponseDTO;
import com.test.food_delivery.entity.Menu;
import com.test.food_delivery.repository.MenuRepository;
import com.test.food_delivery.service.MenuService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Override
    public List<Menu> getMenusByRestaurant(Long restaurantId) {
        return menuRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public List<SearchMenuResponseDTO> searchMenu(String keyword) {

        return menuRepository.searchMenu(keyword)
                .stream()
                .map(menu -> new SearchMenuResponseDTO(
                        menu.getId(),
                        menu.getName(),
                        menu.getPrice(),
                        menu.getRestaurantName()))
                .toList();
    }
}
