package com.challengepay.challengepay.infra.validation.document;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueDocumentValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueDocument {
  String message() default "document is already registered";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
