package com.challengepay.challengepay.infra.user.dto;

import com.challengepay.challengepay.entity.user.model.UserType;
import com.challengepay.challengepay.infra.utils.validation.name.Name;
import com.challengepay.challengepay.infra.utils.validation.password.StrongPassword;
import com.challengepay.challengepay.usecase.user.dto.IUserUpdateData;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UserUpdateData(
    @Schema(description = "Full name", example = "John Young")
    @Name
    @NotBlank(message = "name field is required")
    String name,

    @Schema(description = "Password", example = "aA@1bB#2")
    @StrongPassword
    @NotBlank(message = "password field is required")
    String password,

    @Schema(description = "Type of user in the system, the possible options are in Enum", example = "CUSTOMER")
    UserType userType

) implements IUserUpdateData { }
