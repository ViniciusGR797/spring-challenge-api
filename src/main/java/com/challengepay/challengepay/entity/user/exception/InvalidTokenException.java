package com.challengepay.challengepay.entity.user.exception;

public class InvalidTokenException extends Exception {

    public InvalidTokenException() {
        super("Invalid token");
    }

    public InvalidTokenException(String message) {
        super(message);
    }
    
}
