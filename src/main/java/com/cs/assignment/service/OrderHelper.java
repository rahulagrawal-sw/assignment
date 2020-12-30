package com.cs.assignment.service;

import com.cs.assignment.model.CoffeeShopMenu;
import com.cs.assignment.model.Ingredient;
import com.cs.assignment.model.Order;
import com.cs.assignment.model.StandardDrink;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This is helper class with utility type methods to parse & split
 * input string to build Order object list
 * @author Rahul Agrawal
 */
public class OrderHelper {
    public List<Order> buildOrderRequest(String input) {
        List<Order> orderItems = new ArrayList<>();

        List<String> orderDrinks;
        orderDrinks = Stream.of(input.split("\""))
                .filter(str -> {
                    Pattern p = Pattern.compile("[A-Za-z]");
                    Matcher m = p.matcher(str);
                    return m.find();
                })
                .collect(Collectors.toList());

        orderDrinks.forEach(orderLine->{
            System.out.println("ORDER LINE : "+orderLine);

            List<String> orderDetails;
            orderDetails = Stream.of(orderLine.split(",")).collect(Collectors.toList());

            if(!CollectionUtils.isEmpty(orderDetails)) {
                StandardDrink standardDrink = CoffeeShopMenu.getStandardDrinkFromMenu(orderDetails.get(0));
                Order order = new Order(standardDrink);

                List<String> excludeIngredientNames = orderDetails.subList(1, orderDetails.size());
                List<Ingredient> excludeIngredients = new ArrayList<>();
                for(String ingredientName : excludeIngredientNames) {
                    Ingredient ingredient = CoffeeShopMenu.getIngredientFromMenu(ingredientName.substring(1,ingredientName.length()));
                    excludeIngredients.add(ingredient);
                }
                order.setExcludeList(excludeIngredients);

                orderItems.add(order);
                System.out.println("ORDER DETAILS :"+order.toString());
            }

        });
        return orderItems;
    }
}