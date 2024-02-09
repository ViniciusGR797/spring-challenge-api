package com.challengepay.challengepay.infra.user.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.challengepay.challengepay.entity.user.exception.UserNotFoundException;
import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.infra.user.dto.UserPublicData;
import com.challengepay.challengepay.usecase.user.GetUserUseCase;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class GetMeUserController {
    private final GetUserUseCase getUserUseCase;

    public GetMeUserController(GetUserUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    @Operation(summary = "Get my user", description = "Listing my user", tags = "User")
    @GetMapping("/users/me")
    @ResponseStatus(HttpStatus.OK)
    public UserPublicData getUser(@PathVariable UUID id) throws UserNotFoundException {
        User user = getUserUseCase.execute(id);

        return new UserPublicData(user);
    }
}