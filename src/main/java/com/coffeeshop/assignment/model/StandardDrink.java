package com.coffeeshop.assignment.model;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Optional;

public class StandardDrink {
    private String drinkName;
    private double price;
    private List<Ingredient> ingredients;

    public StandardDrink(String drinkName, double price) {
        this.drinkName = drinkName;
        this.price = price;
    }

    //TODO: remove Ingredient object from List<Ingredient> ingredients
    public void excludeIngredient(String ingredientName) {
        Ingredient ingredientToRemove;
        if(!CollectionUtils.isEmpty(this.ingredients)) {
            Optional<Ingredient> found = Optional.empty();
            for (Ingredient ingredient : this.ingredients) {
                if (ingredient.getIngredientName().equals(ingredientName)) {
                    found = Optional.of(ingredient);
                    this.price -= ingredient.getPrice();
                    break;
                }
            }
            ingredientToRemove = found.get();
            this.ingredients.remove(ingredientToRemove);
        }
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
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