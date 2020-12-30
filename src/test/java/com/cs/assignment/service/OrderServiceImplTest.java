package com.cs.assignment.service;

import com.cs.assignment.exception.InvalidOrderException;
import com.cs.assignment.model.CoffeeShopMenu;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderServiceImplTest {

    private OrderService orderService;

    @Before
    public void setUp() {
        CoffeeShopMenu.seedData();
        orderService = new OrderServiceImpl();
    }

    @Test(expected = InvalidOrderException.class)
    public void orderShouldNotBeBlank() throws InvalidOrderException {
        String myOrder = "";
        orderService.placeOrder(myOrder);
    }

    @Test(expected = InvalidOrderException.class)
    public void allDrinkIngredientsShouldNotBeExcluded() throws InvalidOrderException {
        String myOrder = "CHAI,-tea,-sugar,-milk,-water";
        orderService.placeOrder(myOrder);
    }

    @Test
    public void testPlaceOrderWithStandardSingleDrink() throws InvalidOrderException {
        //given
        String orderInput = "CHAI";
        double expectedValue = 4d;
        //when
        double actualValue = orderService.placeOrder(orderInput);
        //then
        assertEquals(expectedValue, actualValue, 0d);
    }

    @Test
    public void testPlaceOrderWithSingleDrinkAndExcludedIngredients() throws InvalidOrderException {
        //given
        String orderInput = "COFFEE,-sugar";
        double expectedValue = 4.5d;
        //when
        double actualValue = orderService.placeOrder(orderInput);
        //then
        assertEquals(expectedValue, actualValue, 0d);
    }

    @Test
    public void testPlaceOrderWithMultipleDrinkAndExcludedIngredients() throws InvalidOrderException {
        //given
        String myOrder = "[\"CHAI,-sugar\",\"COFFEE,-sugar,-milk\"]";
        double expectedValue = 7d;
        //when
        double actualValue = orderService.placeOrder(myOrder);
        //then
        assertEquals(expectedValue, actualValue, 0d);
    }
}
