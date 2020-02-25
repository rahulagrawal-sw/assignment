package com.coffeeshop.assignment.exception;

import com.coffeeshop.assignment.model.CoffeeShopMenu;
import com.coffeeshop.assignment.model.Order;
import com.coffeeshop.assignment.service.OrderHelper;
import com.coffeeshop.assignment.service.OrderValidator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;

public class InvalidOrderExceptionTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        CoffeeShopMenu.seedData();
    }

    @Test
    public void testInvalidOrderExceptionForBlankOrder() throws InvalidOrderException {
        //test type
        thrown.expect(InvalidOrderException.class);

        //test message
        thrown.expectMessage(is("Each order must have at least one menu item"));

        //test detail
        thrown.expect(hasProperty("errCode"));
        thrown.expect(hasProperty("errCode", is("E4001")));

        OrderValidator orderValidator = new OrderValidator();
        var myOrder4 = "";
        orderValidator.validateOrder(buildOrderRequest(myOrder4));
    }

    @Test
    public void testInvalidOrderExceptionForOrderWithExcludedAllIngredients() throws InvalidOrderException {
        //test type
        thrown.expect(InvalidOrderException.class);

        //test message
        thrown.expectMessage(is("You can not exclude all the ingredients from drink : CHAI"));

        //test detail
        thrown.expect(hasProperty("errCode"));
        thrown.expect(hasProperty("errCode", is("E4002")));

        OrderValidator orderValidator = new OrderValidator();
        var myOrder5 = "CHAI,-teaBag,-sugar,-milk,-water";
        orderValidator.validateOrder(buildOrderRequest(myOrder5));
    }

    @Test
    public void testNoSuchDrink() throws InvalidOrderException {
        //test type
        thrown.expect(InvalidOrderException.class);

        //test message
        thrown.expectMessage(is("No such drink is served in this shop"));

        //test detail
        thrown.expect(hasProperty("errCode"));
        thrown.expect(hasProperty("errCode", is("E4003")));

        OrderValidator orderValidator = new OrderValidator();
        var myOrder5 = "BEER";
        orderValidator.validateOrder(buildOrderRequest(myOrder5));
    }


    private List<Order> buildOrderRequest(String input) {
        OrderHelper orderHelper = new OrderHelper();
        return orderHelper.buildOrderRequest(input);
    }
}