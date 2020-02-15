package com.twu.model.exception;

public class NotExistException extends RuntimeException {

    public NotExistException(String id) {
        super("book not exist, id: " + id);
    }
}
