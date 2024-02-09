package com.challengepay.challengepay.usecase.user;

import java.util.UUID;

import com.challengepay.challengepay.entity.user.exception.UserNotFoundException;
import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.entity.user.model.User;

public class GetUserUseCase {
    private final UserGateway userGateway;

    public GetUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(UUID id) throws UserNotFoundException {
        return this.userGateway
                .findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

}