package com.challengepay.challengepay.infra.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challengepay.challengepay.infra.user.dto.UserPublicData;
import com.challengepay.challengepay.infra.user.dto.UserRegistrationData;
import com.challengepay.challengepay.usecase.user.CreateUserUseCase;

import jakarta.validation.Valid;

@RestController
public class CreateUserController {
    private final CreateUserUseCase createUserUseCase;

    public CreateUserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserPublicData createUser(@Valid @RequestBody UserRegistrationData payload) {
        return new UserPublicData(createUserUseCase.execute(payload));
    }
}