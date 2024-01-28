package com.challengepay.challengepay.entity.user.gateway;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.challengepay.challengepay.entity.user.model.User;

public interface UserGateway {
    void create(User user);
    void update(User user);
    void delete(UUID id);

    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    List<User> findByName(String nameFragment);
}
