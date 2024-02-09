package com.challengepay.challengepay.infra.config.exception;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @Schema(description = "HTTP status code representing the error", example = "400")
    private int status;

    @Schema(description = "Error descriptive message", example = "Validation failed")
    private String message;

    @Schema(description = "Detailed error description", example = "[\"email is already registered\"]")
    private List<String> details;
}
