package com.coffeeshop.assignment.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class CoffeeShopMenu {
    private static Map<String, StandardDrink> coffeeShopMenu;
    private static Map<String, Double> ingredients;

    public static void seedData() {
        coffeeShopMenu = new HashMap<>();
        populateIngredients();

        //COFFEE
        StandardDrink coffee = new StandardDrinkBuilder("COFFEE", 5d)
                .with($ -> $.setIngredients(new ArrayList<>(Arrays. asList("coffeePowder", "milk", "sugar", "water")))).build();
        coffeeShopMenu.put("COFFEE", coffee);

        //CHAI
        StandardDrink chai = new StandardDrinkBuilder("CHAI", 4d)
                .with($ -> $.setIngredients(new ArrayList<>(Arrays. asList("teaBag", "milk", "sugar", "water")))).build();
        coffeeShopMenu.put("CHAI", chai);

        //MOJITO
        StandardDrink mojito = new StandardDrinkBuilder("MOJITO", 7.5d)
                .with($ -> $.setIngredients(new ArrayList<>(Arrays. asList("lemon", "soda", "sugar", "water", "mint")))).build();
        coffeeShopMenu.put("MOJITO", mojito);
    }

    public static StandardDrink getStandardDrinkFromMenu(String drinkName) {
        return coffeeShopMenu.get(drinkName);
    }

    public static double getIngredientPrice(String ingredientName) {
        return ingredients.get(ingredientName);
    }

    private static void populateIngredients() {
        ingredients = new HashMap<>();
        ingredients.put("coffeePowder", 1d);
        ingredients.put("teaBag", 1d);
        ingredients.put("water", 0.5d);
        ingredients.put("sugar", 0.5d);
        ingredients.put("milk", 1d);
        ingredients.put("lemon", 0.5d);
        ingredients.put("soda", 0.5d);
        ingredients.put("mint", 0.5d);
    }
}
