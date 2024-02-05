package com.challengepay.challengepay.infra.user.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record ErrorResponse (
    @Schema(description = "HTTP status code representing the error", example = "400")
    int status,

    @Schema(description = "Error descriptive message", example = "Input data validation error")
    String message,

    @Schema(description = "Detailed error description", example = "input a valid document")
    String error,

    @Schema(description = "Timestamp indicating when the error occurred", example = "04/02/2024 15:30:45")
    LocalDateTime timestamp
) { } 
