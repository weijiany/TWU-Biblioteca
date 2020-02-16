package com.twu.model.exception;

public class NotAValidReturnException extends DomainException {

    public static final String MESSAGE = "That is not a valid book to return.";

    public NotAValidReturnException() {
        super(MESSAGE);
    }
}
