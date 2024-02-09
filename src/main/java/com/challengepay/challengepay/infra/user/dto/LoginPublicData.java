package com.challengepay.challengepay.infra.user.dto;

import com.challengepay.challengepay.usecase.user.dto.ILoginPublicData;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginPublicData(
    @Schema(description = "Access token on endpoints that require authentication", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c")
    String access_token
    
) implements ILoginPublicData { 
    public LoginPublicData(String access_token) {
        this.access_token = access_token;
    }
}
