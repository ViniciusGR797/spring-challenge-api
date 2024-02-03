package com.challengepay.challengepay.infra.user.dto;

import com.challengepay.challengepay.entity.user.model.UserType;
import com.challengepay.challengepay.infra.validation.name.Name;
import com.challengepay.challengepay.infra.validation.password.StrongPassword;
import com.challengepay.challengepay.usecase.user.dto.IUserUpdateData;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateData(
    
    @Name
    @NotBlank(message = "name field is required")
    String name,

    @StrongPassword
    @NotBlank(message = "password field is required")
    String password,

    UserType userType

) implements IUserUpdateData { }
