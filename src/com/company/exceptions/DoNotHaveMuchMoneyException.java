package com.company.exceptions;

public class DoNotHaveMuchMoneyException extends RuntimeException {
    public DoNotHaveMuchMoneyException(String massage) {
        super(massage);
    }
}
