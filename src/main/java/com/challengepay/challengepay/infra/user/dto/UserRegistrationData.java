package com.challengepay.challengepay.infra.user.dto;

import com.challengepay.challengepay.entity.user.model.UserType;
import com.challengepay.challengepay.infra.validation.document.Document;
import com.challengepay.challengepay.infra.validation.document.UniqueDocument;
import com.challengepay.challengepay.infra.validation.email.UniqueEmail;
import com.challengepay.challengepay.infra.validation.name.Name;
import com.challengepay.challengepay.infra.validation.password.StrongPassword;
import com.challengepay.challengepay.usecase.user.dto.IUserRegistrationData;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationData(
        @Name
        @NotBlank(message = "name field is required")
        String name,

        @Document
        @UniqueDocument
        @NotBlank(message = "document field is required")
        String document,

        @UniqueEmail
        @Email(message = "input a valid email")
        @NotBlank(message = "email field is required")
        String email,

        @StrongPassword
        @NotBlank(message = "password field is required")
        String password,

        UserType userType
        
) implements IUserRegistrationData { }
        