package com.coffeeshop.assignment.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Builder pattern aims to “Separate the construction of a complex object from its representation
 * so that the same construction process can create different representations.”
 *
 * This class build StandardDrink object with ingredients, excludes provided ingredient and reduce price of the drink.
 * @author Rahul Agrawal
 */
public class StandardDrinkBuilder {
    private String drinkName;
    private double price;
    private ArrayList ingredients;

    public StandardDrinkBuilder(String drinkName, double price) {
        this.drinkName = drinkName;
        this.price = price;
    }

    public StandardDrinkBuilder with(
            Consumer<StandardDrinkBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public StandardDrink build() {
        StandardDrink drink = new StandardDrink(drinkName,price);
        drink.setIngredients(this.ingredients);
        return drink;
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

    public ArrayList getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList ingredients) {
        this.ingredients = ingredients;
    }
}