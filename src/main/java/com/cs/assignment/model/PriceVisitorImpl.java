package com.cs.assignment.model;

import org.apache.commons.collections4.CollectionUtils;

public class PriceVisitorImpl implements PriceVisitor {

    @Override
    public double visit(Order order) {
        double orderPrice = order.getStandardDrink().getPrice();
        if (!CollectionUtils.isEmpty(order.getExcludeList())) {
            for (Ingredient ingredient : order.getExcludeList()) {
                orderPrice -= ingredient.getPrice();
            }
        }
        return orderPrice;
    }
}
