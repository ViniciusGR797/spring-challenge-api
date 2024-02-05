package com.challengepay.challengepay.infra.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.infra.user.dto.UserPublicData;
import com.challengepay.challengepay.usecase.user.GetAllUserUseCase;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
public class GetAllUserController {

    private final GetAllUserUseCase getAllUserUseCase;

    public GetAllUserController(GetAllUserUseCase getAllUserUseCase) {
        this.getAllUserUseCase = getAllUserUseCase;
    }

    @Operation(summary = "Get all users", description = "Listing all users", tags = "User")
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserPublicData> GetAllUser() {
        List<User> users = this.getAllUserUseCase.execute();

        return users.stream().map(UserPublicData::new).toList();
    }

}