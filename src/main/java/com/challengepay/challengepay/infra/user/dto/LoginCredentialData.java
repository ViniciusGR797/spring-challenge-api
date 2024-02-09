package com.challengepay.challengepay.infra.user.dto;

import com.challengepay.challengepay.infra.validation.password.StrongPassword;
import com.challengepay.challengepay.usecase.user.dto.ILoginCredentialData;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginCredentialData(
        @Schema(description = "Email", example = "test@gmail.com")
        @Email(message = "input a valid email")
        @NotBlank(message = "email field is required")
        String email,

        @Schema(description = "Password", example = "aA@1bB#2")
        @StrongPassword
        @NotBlank(message = "password field is required")
        String password
        
) implements ILoginCredentialData { }
        