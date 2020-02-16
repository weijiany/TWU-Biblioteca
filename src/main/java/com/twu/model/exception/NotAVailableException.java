package com.twu.model.exception;

public class NotAVailableException extends DomainException {

    public static final String MESSAGE = "Sorry, that book is not available.";

    public NotAVailableException() {
        super(MESSAGE);
    }
}
