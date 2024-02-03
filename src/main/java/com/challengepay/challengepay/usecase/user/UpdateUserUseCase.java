package com.challengepay.challengepay.usecase.user;

import java.util.UUID;

import com.challengepay.challengepay.entity.user.exception.UserNotFoundException;
import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.usecase.user.dto.IUserUpdateData;

public class UpdateUserUseCase {
    private final UserGateway userGateway;

    public UpdateUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(UUID id, IUserUpdateData data) throws UserNotFoundException {
        User user = this.userGateway.findById(id)
                .orElseThrow(UserNotFoundException::new);

        user.setName(data.name());
        user.setPassword(data.password());
        user.setUserType(data.userType());

        return this.userGateway.update(user);
    }

}