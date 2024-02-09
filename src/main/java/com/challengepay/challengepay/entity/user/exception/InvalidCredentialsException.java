package com.challengepay.challengepay.entity.user.exception;

public class InvalidCredentialsException extends Exception {

    public InvalidCredentialsException() {
        super("Invalid access credentials");
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }
    
}
