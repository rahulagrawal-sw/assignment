package com.cs.assignment.service;

import com.cs.assignment.exception.InvalidOrderException;
import com.cs.assignment.model.Order;

public interface OrderService {
    double placeOrder(String input) throws InvalidOrderException;
}