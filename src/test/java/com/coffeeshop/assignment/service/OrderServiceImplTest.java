package com.coffeeshop.assignment.service;

import com.coffeeshop.assignment.exception.InvalidOrderException;
import com.coffeeshop.assignment.model.CoffeeShopMenu;
import com.coffeeshop.assignment.model.Order;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void noSuchDrinkServedInShop() throws InvalidOrderException {
        String myOrder = "BEER";
        orderService.placeOrder(myOrder);
    }

    @Test(expected = InvalidOrderException.class)
    public void allDrinkIngredientsShouldNotBeExcluded() throws InvalidOrderException {
        String myOrder = "CHAI,-teaBag,-sugar,-milk,-water";
        orderService.placeOrder(myOrder);
    }

    @Test
    public void testPlaceOrderWithStandardSingleDrink() {
        //given
        Order order = new Order("CHAI");
        double expectedValue = 4d;
        //when
        double actualValue = orderService.calculateDrinkPrice(order);
        //then
        assertEquals(expectedValue, actualValue, 0d);
    }

    @Test
    public void testPlaceOrderWithSingleDrinkAndExcludedIngredients() {
        //given
        Order order = new Order("COFFEE");
        order.addIngredientToExclusion("sugar");
        double expectedValue = 4.5d;
        //when
        double actualValue = orderService.calculateDrinkPrice(order);
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
