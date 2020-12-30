package com.cs.assignment.model;

public class Ingredient {
    public String ingredientName;
    public double price;

    public Ingredient(String ingredientName, double price) {
        this.ingredientName = ingredientName;
        this.price = price;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}