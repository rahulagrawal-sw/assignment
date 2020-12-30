package com.cs.assignment.service;

import com.cs.assignment.exception.InvalidOrderException;
import com.cs.assignment.model.Ingredient;
import com.cs.assignment.model.Order;
import com.cs.assignment.model.StandardDrink;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * This validator class provides methods to validate following and throws InvalidOrderException
 * <ul>
 * <li>Each order must have at least one menu item
 * <li>All ingredients should not be excluded from standard drink menu item
 * </ul>
 *
 * @author Rahul Agrawal
 */
public class OrderValidator {

    public void validateOrder(List<Order> orderItems) throws InvalidOrderException {
        if (CollectionUtils.isEmpty(orderItems)) {
            throw new InvalidOrderException("Each order must have at least one menu item");
        }

        for (Order order : orderItems) {
            if (!CollectionUtils.isEmpty(order.getExcludeList())) {
                checkAllIngredientsAreNotExcluded(order);
            }
        }
    }

    private void checkAllIngredientsAreNotExcluded(Order order) throws InvalidOrderException {
        StandardDrink standardDrink = order.getStandardDrink();
        HashMap<String, Integer> identicalMap = new HashMap<>();

        if (!CollectionUtils.isEmpty(standardDrink.getIngredients())) {
            for (Ingredient ingr : standardDrink.getIngredients()) {
                identicalMap.put(ingr.ingredientName.toUpperCase(), 1);
            }

            for (Ingredient ingrExcl : order.getExcludeList()) {
                identicalMap.remove(ingrExcl.ingredientName.toUpperCase());
            }

            if (identicalMap.size() == 0) {
                throw new InvalidOrderException("You can not exclude all the ingredients from drink : " + standardDrink.getDrinkName());
            }
        }
    }
}