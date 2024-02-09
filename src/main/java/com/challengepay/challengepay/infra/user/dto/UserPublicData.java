package com.challengepay.challengepay.infra.user.dto;

import java.util.UUID;

import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.entity.user.model.UserType;
import com.challengepay.challengepay.usecase.user.dto.IUserPublicData;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserPublicData(

    @Schema(description = "Universal unique identifier", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    UUID id,

    @Schema(description = "Full name", example = "John Young")
    String name,

    @Schema(description = "Identification document, can be CPF or CNPJ", example = "96374505050")
    String document,

    @Schema(description = "Email", example = "test@gmail.com")
    String email,

    @Schema(description = "Type of user in the system, the possible options are in Enum", example = "CUSTOMER")
    UserType userType

) implements IUserPublicData {
    public UserPublicData(User user) {
        this(
            user.getId(),
            user.getName(),
            user.getDocument(),
            user.getEmail(),
            user.getUserType()
        );
    }
}
