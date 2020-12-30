package com.coffeeshop.assignment.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String drinkName;
    private List<String> excludeList;

    public Order(String drinkName) {
        this.drinkName = drinkName;
    }
    public void addIngredientToExclusion(String exclusionIngredient) {
        if(this.excludeList == null) {
            this.excludeList = new ArrayList<>();
        }
        this.excludeList.add(exclusionIngredient);
    }
    public String getDrinkName() {
        return drinkName;
    }

    public List<String> getExcludeList() {
        return excludeList;
    }

    public void setExcludeList(List<String> excludeList) {
        this.excludeList = excludeList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "drinkName='" + drinkName + '\'' +
                ", excludeList=" + excludeList +
                '}';
    }
}
