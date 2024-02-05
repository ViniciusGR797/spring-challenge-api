package com.challengepay.challengepay.infra.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challengepay.challengepay.infra.user.dto.ErrorResponse;
import com.challengepay.challengepay.infra.user.dto.UserPublicData;
import com.challengepay.challengepay.infra.user.dto.UserRegistrationData;
import com.challengepay.challengepay.usecase.user.CreateUserUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "User", description = "User-related operations")
public class CreateUserController {
    private final CreateUserUseCase createUserUseCase;

    public CreateUserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @Operation(summary = "Create user", description = "Creating a new user", tags = "User")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201", 
            description = "Created",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = UserPublicData.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "Bad request",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class), 
                examples = { @ExampleObject(
                    value = "{\"status\": 400, \"message\": \"Bad request\", \"error\": \"Bad request\", \"timestamp\": \"2022-02-04T15:30:00\"}")})),
        @ApiResponse(
            responseCode = "404", 
            description = "Not found",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class), 
                examples = { @ExampleObject(
                    value = "{\"status\": 404, \"message\": \"Data not found\", \"error\": \"Not Found\", \"timestamp\": \"2022-02-04T15:30:00\"}")})),
        @ApiResponse(
            responseCode = "500", 
            description = "Internal server error",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class), 
                examples = { @ExampleObject(
                    value = "{\"status\": 500, \"message\": \"Internal server error\", \"error\": \"Internal Server Error\", \"timestamp\": \"2022-02-04T15:30:00\"}")}))
    })
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserPublicData createUser(@Valid @RequestBody UserRegistrationData payload) {
        return new UserPublicData(createUserUseCase.execute(payload));
    }
}