package com.coffeeshop.assignment.exception;

public class InvalidOrderException extends Exception {
    private String errCode;

    public InvalidOrderException(String errCode, String errorMessage) {
        super(errorMessage);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
