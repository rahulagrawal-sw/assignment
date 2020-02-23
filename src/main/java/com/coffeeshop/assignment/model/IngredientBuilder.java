package com.coffeeshop.assignment.model;

import java.util.List;
import java.util.function.Consumer;

public class IngredientBuilder {
    public String ingredientName;
    public double price;

    public IngredientBuilder with(
            Consumer<IngredientBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public Ingredient build() {
        return new Ingredient(ingredientName, price);
    }
}