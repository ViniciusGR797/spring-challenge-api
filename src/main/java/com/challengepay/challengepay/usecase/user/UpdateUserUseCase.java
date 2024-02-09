package com.challengepay.challengepay.usecase.user;

import java.util.UUID;

import com.challengepay.challengepay.entity.user.exception.UserNotFoundException;
import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.usecase.user.dto.IUserUpdateData;
import com.challengepay.challengepay.usecase.utils.IPasswordEncryptor;

public class UpdateUserUseCase {
    private final UserGateway userGateway;
    private final IPasswordEncryptor iPasswordEncryptor;

    public UpdateUserUseCase(UserGateway userGateway, IPasswordEncryptor iPasswordEncryptor) {
        this.userGateway = userGateway;
        this.iPasswordEncryptor = iPasswordEncryptor;
    }

    public User execute(UUID id, IUserUpdateData data) throws UserNotFoundException {
        User user = this.userGateway.findById(id)
                .orElseThrow(UserNotFoundException::new);

        user.setName(data.name());
        user.setUserType(data.userType());

        if(!iPasswordEncryptor.matches(data.password(), user.getPassword())){
            String encodedPassword = iPasswordEncryptor.encodePassword(data.password());
            user.setPassword(encodedPassword);
        }

        return this.userGateway.update(user);
    }

}