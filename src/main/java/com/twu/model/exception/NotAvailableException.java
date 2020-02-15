package com.twu.model.exception;

public class NotAvailableException extends RuntimeException {

    public static final String MESSAGE = "Sorry, that book is not available.";

    public NotAvailableException() {
        super(MESSAGE);
    }
}
