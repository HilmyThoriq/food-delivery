package com.test.food_delivery.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.test.food_delivery.entity.Menu;
import com.test.food_delivery.interfaces.SearchMenu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByRestaurantId(Long restaurantId);

    @Query(value = """
            SELECT
                m.id AS id,
                m.name AS name,
                m.price AS price,
                r.name AS restaurantName
            FROM menu m
            JOIN restaurant r
                ON m.restaurant_id = r.id
            WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
            ORDER BY m.name
            """, nativeQuery = true)
    List<SearchMenu> searchMenu(String keyword);
}
