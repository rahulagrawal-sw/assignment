package com.cs.assignment.exception;

public class InvalidOrderException extends Exception {
    public InvalidOrderException(String errorMessage) {
        super(errorMessage);
    }
}
