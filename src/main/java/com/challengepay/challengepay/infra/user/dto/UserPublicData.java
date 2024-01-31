package com.challengepay.challengepay.infra.user.dto;

import java.util.UUID;

import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.entity.user.model.UserType;
import com.challengepay.challengepay.usecase.user.dto.IUserPublicData;

public record UserPublicData(

    UUID id,
    String name,
    String document,
    String email,
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
