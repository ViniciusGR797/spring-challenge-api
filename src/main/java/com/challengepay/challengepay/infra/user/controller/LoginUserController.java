package com.challengepay.challengepay.infra.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challengepay.challengepay.entity.user.exception.InvalidCredentialsException;
import com.challengepay.challengepay.entity.user.exception.UserNotFoundException;
import com.challengepay.challengepay.infra.user.dto.LoginCredentialData;
import com.challengepay.challengepay.infra.user.dto.LoginPublicData;
import com.challengepay.challengepay.usecase.user.LoginUserUseCase;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
public class LoginUserController {
    private final LoginUserUseCase loginUserUseCase;

    public LoginUserController(LoginUserUseCase loginUserUseCase) {
        this.loginUserUseCase = loginUserUseCase;
    }

    @Operation(summary = "Login user", description = "Authenticate user credentials", tags = "User")
    @PostMapping("/users/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginPublicData loginUser(@Valid @RequestBody LoginCredentialData payload) throws UserNotFoundException, InvalidCredentialsException  {
        return new LoginPublicData(loginUserUseCase.execute(payload));
    }
}