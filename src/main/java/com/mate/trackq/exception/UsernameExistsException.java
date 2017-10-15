package com.mate.trackq.exception;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException(String msg) {
        super(msg);
    }
}
