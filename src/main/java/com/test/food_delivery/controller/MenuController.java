package com.test.food_delivery.controller;

import com.test.food_delivery.dto.menuDTO.SearchMenuResponseDTO;
import com.test.food_delivery.service.MenuService;
import com.test.food_delivery.util.ApiResponse;
import com.test.food_delivery.util.ResponseUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<SearchMenuResponseDTO>>> searchMenu(
            @RequestParam String keyword) {

        List<SearchMenuResponseDTO> menus = menuService.searchMenu(keyword);

        if (menus.isEmpty()) {
            return ResponseUtil.success(
                    "Menu not found",
                    menus);
        }

        return ResponseUtil.success(
                    "Menus retrieved successfully",
                    menus);

    }

}