package com.cs.assignment.model;

public interface PriceVisitor {
    double visit(Order order);
}
