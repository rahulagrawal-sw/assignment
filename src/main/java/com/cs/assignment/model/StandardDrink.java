package com.cs.assignment.model;
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