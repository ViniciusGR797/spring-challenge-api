package com.challengepay.challengepay.infra.user.controller;

import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.challengepay.challengepay.entity.user.exception.UserNotFoundException;
import com.challengepay.challengepay.infra.user.dto.UserPublicData;
import com.challengepay.challengepay.infra.user.dto.UserUpdateData;
import com.challengepay.challengepay.usecase.user.UpdateUserUseCase;

@RestController
public class UpdateUserController {

    private final UpdateUserUseCase updateUserUseCase;

    public UpdateUserController(UpdateUserUseCase updateUserUseCase) {
        this.updateUserUseCase = updateUserUseCase;
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserPublicData createUser(@PathVariable UUID id, @Valid @RequestBody UserUpdateData data) throws UserNotFoundException {
        return new UserPublicData(updateUserUseCase.execute(id, data));
    }

}