package com.challengepay.challengepay.infra.user.controller;


import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.challengepay.challengepay.entity.user.exception.UserNotFoundException;
import com.challengepay.challengepay.infra.user.dto.UserPublicData;
import com.challengepay.challengepay.usecase.user.DeleteUserUseCase;

@RestController
public class DeleteUserController {

    private final DeleteUserUseCase deleteUserUseCase;

    public DeleteUserController(DeleteUserUseCase deleteUserUseCase) {
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserPublicData deleteUser(@PathVariable UUID id) throws UserNotFoundException {
        return new UserPublicData(deleteUserUseCase.execute(id));
    }

}