package com.cs.assignment.model;

public interface OrderItem {
    double accept(PriceVisitor priceVisitor);
}
