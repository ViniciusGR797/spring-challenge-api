package com.challengepay.challengepay.usecase.user;

import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.usecase.user.dto.IUserRegistrationData;

public class CreateUserUseCase {
    private final UserGateway userGateway;

    public CreateUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(IUserRegistrationData data) {

        User user = new User(
            data.name(), 
            data.document(), 
            data.email(),
            data.password(),
            data.userType()
        );

        return this.userGateway.create(user);
    }
}
