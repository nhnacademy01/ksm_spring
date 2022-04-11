package com.nhnacademy.bank.exception;

public class DifferentCurrencyException extends Exception{
    public DifferentCurrencyException(String message) {
        super(message);
    }
}
