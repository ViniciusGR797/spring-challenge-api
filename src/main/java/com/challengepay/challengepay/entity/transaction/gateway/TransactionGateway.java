package com.challengepay.challengepay.entity.transaction.gateway;

import java.util.Optional;
import java.util.UUID;

import com.challengepay.challengepay.entity.transaction.model.Transaction;

public interface TransactionGateway {
    void create(Transaction transaction);

    Optional<Transaction> findById(UUID id);
}
