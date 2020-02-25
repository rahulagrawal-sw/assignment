package com.coffeeshop.assignment.service;

import com.coffeeshop.assignment.exception.InvalidOrderException;
import com.coffeeshop.assignment.model.CoffeeShopMenu;
import com.coffeeshop.assignment.model.Order;
import com.coffeeshop.assignment.model.StandardDrink;
import org.apache.commons.collections4.CollectionUtils;

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

        var ref = new Object() {
            double totalOrderPrice = 0d;
        };

        orderItems.forEach(order -> {
                    ref.totalOrderPrice += calculateDrinkPrice(order);
                }
            );

        return ref.totalOrderPrice;
    }

    public double calculateDrinkPrice(Order order) {
        StandardDrink standardDrink = CoffeeShopMenu.getStandardDrinkFromMenu(order.getDrinkName());
        if(!CollectionUtils.isEmpty(order.getExcludeList())) {
            order.getExcludeList()
                    .forEach(exclude -> standardDrink.excludeIngredient(exclude.substring(1)));
        }
        System.out.printf("%s drink price is : %.2f", standardDrink.getDrinkName(), standardDrink.getPrice());
        System.out.println("");

        return standardDrink.getPrice();
    }
}