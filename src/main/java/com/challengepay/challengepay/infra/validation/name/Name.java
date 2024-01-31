package com.challengepay.challengepay.infra.validation.name;

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
    
  String message() default "input a valid name";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

}
