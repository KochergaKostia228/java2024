package com.company.exeption;

public class InvalidDenominationException extends ATMException {
    public InvalidDenominationException(String message) {
        super(message);
    }
}
