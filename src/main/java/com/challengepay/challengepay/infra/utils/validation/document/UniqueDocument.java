package com.challengepay.challengepay.infra.utils.validation.document;

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
  String message() default "Document is already registered. This document has already been used by another user, try using a different document";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
