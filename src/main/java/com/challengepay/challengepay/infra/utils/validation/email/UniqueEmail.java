package com.challengepay.challengepay.infra.utils.validation.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
  String message() default "Email is already registered. This email has already been used by another user, try using a different email";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
