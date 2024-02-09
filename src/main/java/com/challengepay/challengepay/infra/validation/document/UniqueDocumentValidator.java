package com.challengepay.challengepay.infra.validation.document;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challengepay.challengepay.infra.config.db.repository.UserRepository;
import com.challengepay.challengepay.infra.config.db.schema.UserSchema;

import java.util.Optional;

@Component
public class UniqueDocumentValidator implements ConstraintValidator<UniqueDocument, String> {

  @Autowired
  private UserRepository repository;

  @Override
  public boolean isValid(String document, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<UserSchema> user = repository.findByDocument(document);
      return user.isEmpty();
    }

    return true;
  }

}
