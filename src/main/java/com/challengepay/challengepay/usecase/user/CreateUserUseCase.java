package com.challengepay.challengepay.usecase.user;

import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.usecase.user.dto.IUserRegistrationData;
import com.challengepay.challengepay.usecase.utils.IPasswordEncryptor;

public class CreateUserUseCase {
    private final UserGateway userGateway;
    private final IPasswordEncryptor iPasswordEncryptor;

    public CreateUserUseCase(UserGateway userGateway, IPasswordEncryptor iPasswordEncryptor) {
        this.userGateway = userGateway;
        this.iPasswordEncryptor = iPasswordEncryptor;
    }

    public User execute(IUserRegistrationData data) {
        String encodedPassword = iPasswordEncryptor.encodePassword(data.password());

        User user = new User(
            data.name(), 
            data.document(), 
            data.email(),
            encodedPassword,
            data.userType()
        );

        return this.userGateway.create(user);
    }
}
