package com.challengepay.challengepay.entity.transaction.exception;

public class TransactionNotFoundException extends Exception {

    public TransactionNotFoundException() {
        super("Transaction not found");
    }

    public TransactionNotFoundException(String message) {
        super(message);
    }
    
}
