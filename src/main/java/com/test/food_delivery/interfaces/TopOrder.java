package com.test.food_delivery.interfaces;

import java.math.BigDecimal;

public interface TopOrder {
    Long getOrderId();

    String getCustomerName();

    BigDecimal getTotalPrice();

    Integer getTotalItems();
}
