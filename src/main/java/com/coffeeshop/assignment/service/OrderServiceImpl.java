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
    public double placeOrder(final String input) throws InvalidOrderException {
        //Prepare order request object using provided input string
        OrderHelper orderHelper = new OrderHelper();
        List<Order> orderItems = orderHelper.buildOrderRequest(input);

        //Validate order
        OrderValidator orderValidator = new OrderValidator();
        orderValidator.validateOrder(orderItems);

        //Calculate total price of the order, which may have multiple items
        double totalOrderPrice = 0d;
        for (Order order : orderItems) {
            totalOrderPrice += calculateDrinkPrice(order);
        }

        return totalOrderPrice;
    }

    public double calculateDrinkPrice(Order order) {
        StandardDrink standardDrink = CoffeeShopMenu.getStandardDrinkFromMenu(order.getDrinkName());
        if(!CollectionUtils.isEmpty(order.getExcludeList())) {
            for (String ingredientToExclude : order.getExcludeList()) {
                standardDrink.excludeIngredient(ingredientToExclude, CoffeeShopMenu.getIngredientPrice(ingredientToExclude));
            }
        }
        System.out.printf("%s drink price is : %.2f \n", standardDrink.getDrinkName(), standardDrink.getPrice());

        return standardDrink.getPrice();
    }
}