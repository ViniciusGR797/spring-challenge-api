package com.challengepay.challengepay.infra.user.dto;

import com.challengepay.challengepay.entity.user.model.UserType;
import com.challengepay.challengepay.infra.validation.document.Document;
import com.challengepay.challengepay.infra.validation.document.UniqueDocument;
import com.challengepay.challengepay.infra.validation.email.UniqueEmail;
import com.challengepay.challengepay.infra.validation.name.Name;
import com.challengepay.challengepay.infra.validation.password.StrongPassword;
import com.challengepay.challengepay.usecase.user.dto.IUserRegistrationData;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationData(
        @Schema(description = "Full name", example = "John Young")
        @Name
        @NotBlank(message = "name field is required")
        String name,

        @Schema(description = "Identification document, can be CPF or CNPJ", example = "96374505050")
        @Document
        @UniqueDocument
        @NotBlank(message = "document field is required")
        String document,

        @Schema(description = "Email", example = "test@gmail.com")
        @UniqueEmail
        @Email(message = "input a valid email")
        @NotBlank(message = "email field is required")
        String email,

        @Schema(description = "Password", example = "aA@1bB#2")
        @StrongPassword
        @NotBlank(message = "password field is required")
        String password,

        @Schema(description = "Type of user in the system, the possible options are in Enum", example = "CUSTOMER")
        UserType userType
        
) implements IUserRegistrationData { }
        