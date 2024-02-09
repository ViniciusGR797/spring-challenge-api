package com.challengepay.challengepay.entity.user.gateway;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.challengepay.challengepay.entity.user.model.User;

public interface UserGateway {
    User create(User user);
    User update(User user);
    void delete(UUID id);

    Optional<User> findById(UUID id);
    Optional<User> findByDocument(String document);
    Optional<User> findByEmail(String email);
    List<User> findByName(String nameFragment);
    List<User> findAll();
}
