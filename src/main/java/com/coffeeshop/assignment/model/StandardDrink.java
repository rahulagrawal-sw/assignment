package com.coffeeshop.assignment.model;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class StandardDrink {
    private final String drinkName;
    private double price;
    private List<String> ingredients;

    public StandardDrink(String drinkName, double price) {
        this.drinkName = drinkName;
        this.price = price;
    }

    public void excludeIngredient(String ingredientName, double ingredientPrice) {
        if(!CollectionUtils.isEmpty(this.ingredients)) {
            if (this.ingredients.stream().anyMatch(ingredient -> ingredient.equals(ingredientName))) {
                this.ingredients.remove(ingredientName);
                this.price -= ingredientPrice;
            }
        }
    }

    public String getDrinkName() {
        return drinkName;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "StandardDrink{" +
                "drinkName='" + drinkName + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                '}';
    }
}