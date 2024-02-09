package com.challengepay.challengepay.infra.utils.validation.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StrongPasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {
  String message() default "Enter a strong password. Must contain at least 8 characters, an uppercase letter, a lowercase letter, a number and a special character";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
