package com.coffeeshop.assignment.service;

import com.coffeeshop.assignment.exception.InvalidOrderException;
import com.coffeeshop.assignment.model.CoffeeShopMenu;
import com.coffeeshop.assignment.model.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OrderValidatorTest {

    OrderValidator orderValidator;

    @Before
    public void setUp() {
        CoffeeShopMenu.seedData();
        orderValidator = new OrderValidator();
    }

    @Test(expected = InvalidOrderException.class)
    public void testInvalidOrderExceptionForBlankOrder() throws InvalidOrderException {
        OrderValidator orderValidator = new OrderValidator();
        var myOrder4 = "";
        orderValidator.validateOrder(buildOrderRequest(myOrder4));
    }

    @Test(expected = InvalidOrderException.class)
    public void testInvalidOrderExceptionForOrderWithExcludedAllIngredients() throws InvalidOrderException {
        OrderValidator orderValidator = new OrderValidator();
        var myOrder5 = "CHAI,-teaBag,-sugar,-milk,-water";
        orderValidator.validateOrder(buildOrderRequest(myOrder5));
    }

    @Test(expected = InvalidOrderException.class)
    public void testNoSuchDrink() throws InvalidOrderException {
        OrderValidator orderValidator = new OrderValidator();
        var myOrder5 = "BEER";
        orderValidator.validateOrder(buildOrderRequest(myOrder5));
    }

    private List<Order> buildOrderRequest(String input) {
        OrderHelper orderHelper = new OrderHelper();
        return orderHelper.buildOrderRequest(input);
    }
}