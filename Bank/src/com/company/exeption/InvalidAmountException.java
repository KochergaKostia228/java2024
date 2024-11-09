package com.company.exeption;

public class InvalidAmountException extends ATMException {
    public InvalidAmountException(String message) {
        super(message);
    }
}
