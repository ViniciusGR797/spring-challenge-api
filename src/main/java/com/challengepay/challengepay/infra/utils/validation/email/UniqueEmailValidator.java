package com.challengepay.challengepay.infra.utils.validation.email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challengepay.challengepay.infra.config.db.repository.UserRepository;
import com.challengepay.challengepay.infra.config.db.schema.UserSchema;

import java.util.Optional;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

  @Autowired
  private UserRepository repository;

  @Override
  public boolean isValid(String document, ConstraintValidatorContext context) {
    if (document == null || document.isBlank()) return false;
    if (repository != null) {
      Optional<UserSchema> user = repository.findByEmail(document);
      return user.isEmpty();
    }

    return true;
  }

}
