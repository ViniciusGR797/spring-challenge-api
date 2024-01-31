package com.challengepay.challengepay.usecase.user.dto;

import com.challengepay.challengepay.entity.user.model.UserType;

public interface IUserRegistrationData {

    String name();
    String document();
    String email();
    String password();
    UserType userType();

}
