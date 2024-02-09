package com.challengepay.challengepay.infra.utils.validation.document;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DocumentValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Document {
  String message() default "Enter a valid document. Must be a valid identification document such as CPF/CNPJ";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
