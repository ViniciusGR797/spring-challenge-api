package com.challengepay.challengepay.infra.config.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.challengepay.challengepay.entity.user.exception.InvalidCredentialsException;
import com.challengepay.challengepay.entity.user.exception.InvalidTokenException;
import com.challengepay.challengepay.entity.user.exception.UserNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandling(MethodArgumentNotValidException exception) {
        int statusCode = HttpStatus.BAD_REQUEST.value();

        List<String> errorMessages = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> errorMessages.add(error.getDefaultMessage()));
        exception.getBindingResult().getGlobalErrors().forEach(error -> errorMessages.add(error.getDefaultMessage()));

        ErrorResponse errorResponse = new ErrorResponse(
            statusCode,
            "Invalid input",
            errorMessages
        );

        return ResponseEntity.status(statusCode).body(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<ErrorResponse> httpMessageNotReadableExceptionHandling(HttpMessageNotReadableException exception) {
        int statusCode = HttpStatus.BAD_REQUEST.value();

        List<String> errorMessages = new ArrayList<>();
        String errorMessage = exception.getMessage();
        String improvedErrorMessage = errorMessage
            .substring(errorMessage.indexOf(":") + 2)
            .replace("com.challengepay.challengepay.entity.user.model.", "");
        errorMessages.add(improvedErrorMessage);

        ErrorResponse errorResponse = new ErrorResponse(
            statusCode,
            "Invalid input",
            errorMessages
        );

        return ResponseEntity.status(statusCode).body(errorResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ErrorResponse> userNotFoundExceptionHandler(UserNotFoundException exception){
        int statusCode = HttpStatus.NOT_FOUND.value();
        
        ErrorResponse errorResponse = new ErrorResponse(
            statusCode, 
            new UserNotFoundException().getMessage(), 
            Arrays.asList(exception.getMessage())
        );
        return ResponseEntity.status(statusCode).body(errorResponse);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    private ResponseEntity<ErrorResponse> invalidCredentialsExceptionHandler(InvalidCredentialsException exception){
        int statusCode = HttpStatus.UNAUTHORIZED.value();
        
        ErrorResponse errorResponse = new ErrorResponse(
            statusCode, 
            new InvalidCredentialsException().getMessage(), 
            Arrays.asList(exception.getMessage())
        );
        return ResponseEntity.status(statusCode).body(errorResponse);
    }

    @ExceptionHandler(InvalidTokenException.class)
    private ResponseEntity<ErrorResponse> invalidTokenExceptionHandler(InvalidTokenException exception){
        int statusCode = HttpStatus.UNAUTHORIZED.value();
        
        ErrorResponse errorResponse = new ErrorResponse(
            statusCode, 
            new InvalidTokenException().getMessage(), 
            Arrays.asList(exception.getMessage())
        );
        return ResponseEntity.status(statusCode).body(errorResponse);
    }

}
