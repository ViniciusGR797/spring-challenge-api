package com.challengepay.challengepay.entity.transaction.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {

    private UUID id;
    private UUID senderId;
    private UUID receiverId;
    private BigDecimal amount;

    public Transaction(UUID senderId, UUID receiverId, BigDecimal amount) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public UUID getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }   
    
}
