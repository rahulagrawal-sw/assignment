package com.coffeeshop.assignment.service;

import com.coffeeshop.assignment.exception.InvalidOrderException;
import com.coffeeshop.assignment.model.CoffeeShopMenu;
import com.coffeeshop.assignment.model.Ingredient;
import com.coffeeshop.assignment.model.Order;
import com.coffeeshop.assignment.model.StandardDrink;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This validator class provides methods to validate following and throws InvalidOrderException
 * <ul>
 * <li>Each order must have at least one menu item
 * <li>All ingredients should not be excluded from standard drink menu item
 * </ul>
 * @author Rahul Agrawal
 */
public class OrderValidator {

    public void validateOrder(List<Order> orderItems) throws InvalidOrderException {
        if(CollectionUtils.isEmpty(orderItems)) {
            throw new InvalidOrderException("Each order must have at least one menu item");
        }

        for (Order order : orderItems) {
            if (!CollectionUtils.isEmpty(order.getExcludeList())) {
                checkAllIngredientsAreNotExcluded(order);
            }
        }
    }

    private void checkAllIngredientsAreNotExcluded(Order order) throws InvalidOrderException {
        StandardDrink standardDrink = CoffeeShopMenu.getStandardDrinkFromMenu(order.getDrinkName());
        if(!CollectionUtils.isEmpty(standardDrink.getIngredients())) {
            List<Ingredient> ingredientList = standardDrink.getIngredients();
            List<String> drinkIngredientList = ingredientList.stream()
                    .map(ingredient -> ingredient.getIngredientName())
                    .collect(Collectors.toList());
            boolean result = drinkIngredientList.stream().allMatch(ingredientName -> order.getExcludeList().contains("-"+ingredientName));
            if(result) {
                throw new InvalidOrderException("You can not exclude all the ingredients from drink : " + standardDrink.getDrinkName());
            }
        }
    }
}