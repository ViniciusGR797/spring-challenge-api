package com.challengepay.challengepay.infra.validation.name;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class NameValidator implements ConstraintValidator<Name, String> {

  @Override
  public boolean isValid(String name, ConstraintValidatorContext context) {
    if (name == null || name.isBlank()) return false;
    return name.matches("^[a-zA-Zà-úÀ-Ú]{3,}(?: [a-zA-Zà-úÀ-Ú]+){1,}$");
  }

}
