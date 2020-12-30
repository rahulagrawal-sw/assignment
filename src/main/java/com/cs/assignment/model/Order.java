package com.cs.assignment.model;

import java.util.List;

public class Order implements OrderItem {
    private StandardDrink standardDrink;
    private List<Ingredient> excludeList;

    public Order(StandardDrink standardDrink) {
        this.standardDrink = standardDrink;
    }

    @Override
    public double accept(PriceVisitor priceVisitor) {
        return priceVisitor.visit(this);
    }


    public StandardDrink getStandardDrink() {
        return standardDrink;
    }

    public void setStandardDrink(StandardDrink standardDrink) {
        this.standardDrink = standardDrink;
    }

    public List<Ingredient> getExcludeList() {
        return excludeList;
    }

    public void setExcludeList(List<Ingredient> excludeList) {
        this.excludeList = excludeList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "drinkName='" + standardDrink.getDrinkName() + '\'' +
                ", excludeList=" + excludeList +
                '}';
    }
}
