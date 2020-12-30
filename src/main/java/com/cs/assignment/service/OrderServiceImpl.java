package com.cs.assignment.service;

import com.cs.assignment.exception.InvalidOrderException;
import com.cs.assignment.model.Order;
import com.cs.assignment.model.PriceVisitor;
import com.cs.assignment.model.PriceVisitorImpl;

import java.util.List;

/**
 * Concrete implementation of the <tt>OrderService</tt> interface. Has the following
 * responsibilities
 * <ul>
 * <li>Place order with given input string
 * <li>Calculate price of individual order item
 * </ul>
 *
 * @author Rahul Agrawal
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public double placeOrder(String input) throws InvalidOrderException {
        OrderHelper orderHelper = new OrderHelper();
        List<Order> orderItems = orderHelper.buildOrderRequest(input);

        OrderValidator orderValidator = new OrderValidator();
        orderValidator.validateOrder(orderItems);


        double totalOrderPrice = 0d;
        PriceVisitor priceVisitor = new PriceVisitorImpl();
        for (Order order : orderItems) {
            totalOrderPrice += order.accept(priceVisitor);
        }
        System.out.println(String.format("Total Price for Order is %2f", totalOrderPrice));
        return totalOrderPrice;

    }
}