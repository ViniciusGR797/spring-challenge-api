package com.challengepay.challengepay.usecase.user;

import java.util.List;

import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.entity.user.model.User;

public class GetAllUserUseCase {
    private final UserGateway userGateway;

    public GetAllUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<User> execute() {
        return this.userGateway.findAll();
    }

}