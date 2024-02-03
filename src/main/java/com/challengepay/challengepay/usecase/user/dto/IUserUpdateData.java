package com.challengepay.challengepay.usecase.user.dto;

import com.challengepay.challengepay.entity.user.model.UserType;

public interface IUserUpdateData {
    String name();
    String password();
    UserType userType();
}