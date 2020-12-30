package com.cs.assignment.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class CoffeeShopMenu {
    private static Map<String, StandardDrink> coffeeShopMenu;
    private static Map<String, Ingredient> coffeeShopMenuIngredients;

    public static void seedData() {
        coffeeShopMenu = new HashMap<>();
        coffeeShopMenuIngredients = new HashMap<>();

        //All required Ingredients
        Ingredient sugar = createSugar();
        coffeeShopMenuIngredients.put("SUGAR", sugar);
        Ingredient water = createWater();
        coffeeShopMenuIngredients.put("WATER", water);
        Ingredient milk = createMilk();
        coffeeShopMenuIngredients.put("MILK", milk);
        Ingredient teaBag = createTea();
        coffeeShopMenuIngredients.put("TEA", teaBag);
        Ingredient coffeePowder = createCoffeePowder();
        coffeeShopMenuIngredients.put("COFFEEPOWDER", coffeePowder);
        Ingredient lemon = createLemon();
        coffeeShopMenuIngredients.put("LEMON", lemon);
        Ingredient soda = createSoda();
        coffeeShopMenuIngredients.put("SODA", soda);
        Ingredient mint = createMint();
        coffeeShopMenuIngredients.put("MINT", mint);

        //COFFEE
        StandardDrink coffee = new StandardDrinkBuilder("COFFEE", 5d)
                .with($ -> {
                    $.setIngredients(new ArrayList<>(Arrays.asList(coffeePowder, milk, sugar, water)));
                }).build();
        coffeeShopMenu.put("COFFEE", coffee);

        //CHAI
        StandardDrink chai = new StandardDrinkBuilder("CHAI", 4d)
                .with($ -> {
                    $.setIngredients(new ArrayList<>(Arrays.asList(teaBag, milk, sugar, water)));
                }).build();
        coffeeShopMenu.put("CHAI", chai);

        //MOJITO
        StandardDrink mojito = new StandardDrinkBuilder("MOJITO", 7.5d)
                .with($ -> {
                    $.setIngredients(new ArrayList<>(Arrays.asList(lemon, soda, sugar, water, mint)));
                }).build();
        coffeeShopMenu.put("MOJITO", mojito);
    }

    public static StandardDrink getStandardDrinkFromMenu(String drinkName) {
        return coffeeShopMenu.get(drinkName);
    }

    public static Ingredient getIngredientFromMenu(String ingredientName) {
        return coffeeShopMenuIngredients.get(ingredientName.toUpperCase());
    }

    private static Ingredient createTea() {
        return new IngredientBuilder()
                .with($_ingredient -> {
                    $_ingredient.ingredientName = "tea";
                    $_ingredient.price = 1d;
                }).build();
    }

    private static Ingredient createCoffeePowder() {
        return new IngredientBuilder()
                .with($_ingredient -> {
                    $_ingredient.ingredientName = "coffee";
                    $_ingredient.price = 1d;
                }).build();
    }

    private static Ingredient createMilk() {
        return new IngredientBuilder()
                .with($_ingredient -> {
                    $_ingredient.ingredientName = "milk";
                    $_ingredient.price = 1d;
                }).build();
    }

    private static Ingredient createSugar() {
        return new IngredientBuilder()
                .with($_ingredient -> {
                    $_ingredient.ingredientName = "sugar";
                    $_ingredient.price = 0.5d;
                }).build();
    }

    private static Ingredient createLemon() {
        return new IngredientBuilder()
                .with($_ingredient -> {
                    $_ingredient.ingredientName = "lemon";
                    $_ingredient.price = 0.5d;
                }).build();
    }

    private static Ingredient createSoda() {
        return new IngredientBuilder()
                .with($_ingredient -> {
                    $_ingredient.ingredientName = "soda";
                    $_ingredient.price = 0.5d;
                }).build();
    }

    private static Ingredient createMint() {
        return new IngredientBuilder()
                .with($_ingredient -> {
                    $_ingredient.ingredientName = "mint";
                    $_ingredient.price = 0.5d;
                }).build();
    }

    private static Ingredient createWater() {
        return new IngredientBuilder()
                .with($_ingredient -> {
                    $_ingredient.ingredientName = "water";
                    $_ingredient.price = 0.5d;
                }).build();
    }
}
