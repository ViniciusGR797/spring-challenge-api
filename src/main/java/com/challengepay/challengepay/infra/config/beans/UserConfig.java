package com.challengepay.challengepay.infra.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.infra.config.db.repository.UserRepository;
import com.challengepay.challengepay.infra.user.gateway.UserDatabaseGateway;
import com.challengepay.challengepay.infra.utils.PasswordEncryptor;
import com.challengepay.challengepay.infra.utils.TokenManager;
import com.challengepay.challengepay.usecase.user.CreateUserUseCase;
import com.challengepay.challengepay.usecase.user.DeleteUserUseCase;
import com.challengepay.challengepay.usecase.user.GetAllUserUseCase;
import com.challengepay.challengepay.usecase.user.GetUserUseCase;
import com.challengepay.challengepay.usecase.user.LoginUserUseCase;
import com.challengepay.challengepay.usecase.user.UpdateUserUseCase;

@Configuration
public class UserConfig {
    
    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        UserGateway userGateway = new UserDatabaseGateway(userRepository);
        PasswordEncryptor passwordEncryptor = new PasswordEncryptor();
        return new CreateUserUseCase(userGateway, passwordEncryptor);
    }

    @Bean
    public GetUserUseCase getUserUseCase(UserRepository userRepository) {
        UserGateway userGateway = new UserDatabaseGateway(userRepository);
        return new GetUserUseCase(userGateway);
    }

    @Bean
    public GetAllUserUseCase getAllUserUseCase(UserRepository userRepository) {
        UserGateway userGateway = new UserDatabaseGateway(userRepository);
        return new GetAllUserUseCase(userGateway);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UserRepository userRepository) {
        UserGateway userGateway = new UserDatabaseGateway(userRepository);
        PasswordEncryptor passwordEncryptor = new PasswordEncryptor();
        return new UpdateUserUseCase(userGateway, passwordEncryptor);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase(UserRepository userRepository) {
        UserGateway userGateway = new UserDatabaseGateway(userRepository);
        return new DeleteUserUseCase(userGateway);
    }

    @Bean
    public LoginUserUseCase loginUserUseCase(UserRepository userRepository) {
        UserGateway userGateway = new UserDatabaseGateway(userRepository);
        PasswordEncryptor passwordEncryptor = new PasswordEncryptor();
        TokenManager tokenManager = new TokenManager();
        return new LoginUserUseCase(userGateway, passwordEncryptor, tokenManager);
    }

}
