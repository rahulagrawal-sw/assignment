package com.coffeeshop.assignment.service;

import com.coffeeshop.assignment.model.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderHelperTest {

    private OrderHelper orderHelper;

    @Before
    public void setUp() {
        orderHelper = new OrderHelper();
    }

    @Test
    public void testBuildOrderRequestWithOnlyStandardDrink() {
        //given
        String myOrder = "CHAI";
        //when
        List<Order> orderRequest = orderHelper.buildOrderRequest(myOrder);
        //then
        assertEquals(1, orderRequest.size(), 0d);
        assertNotNull(orderRequest.get(0).getExcludeList());
    }

    @Test
    public void testBuildOrderRequestWithMultipleStandardDrink() {
        //given
        String myOrder = "[\"CHAI,-sugar\",\"COFFEE,-sugar,-milk\"]";
        //when
        List<Order> orderRequest = orderHelper.buildOrderRequest(myOrder);
        //then
        assertEquals(2, orderRequest.size(), 0d);
        assertEquals(1, orderRequest.get(0).getExcludeList().size(), 0d);
        assertEquals(2, orderRequest.get(1).getExcludeList().size(), 0d);
    }

    @Test
    public void testBuildOrderRequestWithBlankInput() {
        //given
        String myOrder = "";
        //when
        List<Order> orderRequest = orderHelper.buildOrderRequest(myOrder);
        //then
        assertEquals(0, orderRequest.size(), 0d);
    }

}