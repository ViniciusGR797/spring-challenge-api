package com.challengepay.challengepay.infra.config.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challengepay.challengepay.infra.config.db.schema.UserSchema;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserSchema, UUID> {
  Optional<UserSchema> findById(UUID id);
  Optional<UserSchema> findByDocument(String document);
  Optional<UserSchema> findByEmail(String email);
  Collection<UserSchema> findByName(String name);
}
