package com.coffeeshop.assignment.exception;

public class InvalidOrderException extends Exception {
    public InvalidOrderException(String errorMessage) {
        super(errorMessage);
    }
}
