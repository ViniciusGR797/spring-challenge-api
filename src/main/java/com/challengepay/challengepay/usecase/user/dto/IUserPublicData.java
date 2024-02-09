package com.challengepay.challengepay.usecase.user.dto;

import java.util.UUID;

import com.challengepay.challengepay.entity.user.model.UserType;

public interface IUserPublicData {
    UUID id();
    String name();
    String document();
    String email();
    UserType userType();
}