package com.mate.trackq.exception;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String msg) {
        super(msg);
    }
}
