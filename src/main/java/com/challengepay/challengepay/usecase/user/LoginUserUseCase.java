package com.challengepay.challengepay.usecase.user;

import com.challengepay.challengepay.entity.user.exception.InvalidCredentialsException;
import com.challengepay.challengepay.entity.user.exception.UserNotFoundException;
import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.entity.user.model.User;
import com.challengepay.challengepay.usecase.user.dto.ILoginCredentialData;
import com.challengepay.challengepay.usecase.utils.IPasswordEncryptor;
import com.challengepay.challengepay.usecase.utils.ITokenManager;

public class LoginUserUseCase {
    private final UserGateway userGateway;
    private final IPasswordEncryptor iPasswordEncryptor;
    private final ITokenManager iTokenManager;

    public LoginUserUseCase(UserGateway userGateway, IPasswordEncryptor iPasswordEncryptor, ITokenManager iTokenManager) {
        this.userGateway = userGateway;
        this.iPasswordEncryptor = iPasswordEncryptor;
        this.iTokenManager = iTokenManager;
    }

    public String execute(ILoginCredentialData data) throws UserNotFoundException, InvalidCredentialsException {
        User user = this.userGateway.findByEmail(data.email())
            .orElseThrow(() -> new InvalidCredentialsException("Invalid login credentials to access the application"));

        if(!iPasswordEncryptor.matches(data.password(), user.getPassword())){
            throw new InvalidCredentialsException("Invalid login credentials to access the application");
        }

        String token = iTokenManager.createToken(user.getId().toString());

        return token;
    }
}
