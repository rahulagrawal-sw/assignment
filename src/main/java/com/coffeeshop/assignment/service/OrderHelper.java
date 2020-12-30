package com.coffeeshop.assignment.service;

import com.coffeeshop.assignment.model.Order;
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

        for (String orderLine : orderDrinks) {
            System.out.println("ORDER LINE : " + orderLine);

            List<String> orderDetails;
            orderDetails = Stream.of(orderLine.split(",")).collect(Collectors.toList());

            if (!CollectionUtils.isEmpty(orderDetails)) {
                Order order = new Order(orderDetails.get(0));
                List<String> exclusions = orderDetails.subList(1, orderDetails.size());
                order.setExcludeList(
                        exclusions.stream()
                                .map(str -> str.substring(1))
                                .collect(Collectors.toList())
                );
                orderItems.add(order);
                System.out.println("ORDER DETAILS :" + order.toString());
            }
        }
        return orderItems;
    }
}