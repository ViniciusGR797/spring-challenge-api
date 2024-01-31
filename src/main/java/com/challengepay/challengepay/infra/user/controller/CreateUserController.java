package com.challengepay.challengepay.infra.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World!";
    }

    @PostMapping("/users")
    public UserPublicData createUser(@Valid @RequestBody UserRegistrationData payload) {
        return new UserPublicData(createUserUseCase.execute(payload));
    }

}