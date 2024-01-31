package com.challengepay.challengepay.infra.user.gateway;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.infra.config.db.repository.UserRepository;
import com.challengepay.challengepay.infra.config.db.schema.UserSchema;

public class UserDatabaseGateway implements UserGateway {

    private final UserRepository userRepository;

    public UserDatabaseGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(new UserSchema(user)).toUser();
    }

    @Override
    public User update(User user) {
        return this.userRepository.save(new UserSchema(user)).toUser();
    }

    @Override
    public void delete(UUID id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository
                .findById(id)
                .map(UserSchema::toUser);
    }

    @Override
    public Optional<User> findByDocument(String document) {
        return userRepository
                .findByDocument(document)
                .map(UserSchema::toUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .map(UserSchema::toUser);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository
                .findByName(name)
                .stream()
                .map(UserSchema::toUser)
                .toList();
    }

    @Override
    public List<User> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserSchema::toUser)
                .toList();
    }

}