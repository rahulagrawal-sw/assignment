package com.coffeeshop.assignment.service;

import com.coffeeshop.assignment.exception.InvalidOrderException;
import com.coffeeshop.assignment.model.Order;

public interface OrderService {
    double placeOrder(final String input) throws InvalidOrderException;
    double calculateDrinkPrice(Order order);
}