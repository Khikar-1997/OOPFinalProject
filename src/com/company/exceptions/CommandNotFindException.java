package com.company.exceptions;

public class CommandNotFindException extends RuntimeException {
    public CommandNotFindException(String massage) {
        super(massage);
    }
}
