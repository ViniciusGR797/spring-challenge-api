package com.challengepay.challengepay.entity.user.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User not found");
    }
    
}
