package com.challengepay.challengepay.infra.utils.validation.name;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Name {
  String message() default "Enter a valid name. Must have first and last name, no numbers or special characters";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
