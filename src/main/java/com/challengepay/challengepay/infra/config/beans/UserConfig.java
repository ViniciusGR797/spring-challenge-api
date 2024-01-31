package com.challengepay.challengepay.infra.config.beans;

// import java.util.ResourceBundle;

// import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.challengepay.challengepay.entity.user.gateway.UserGateway;
import com.challengepay.challengepay.infra.config.db.repository.UserRepository;
import com.challengepay.challengepay.infra.user.gateway.UserDatabaseGateway;
import com.challengepay.challengepay.usecase.user.CreateUserUseCase;

@Configuration
public class UserConfig {
    
    // @Bean
    // public ResourceBundle messageBundle() {
    //     return ResourceBundle.getBundle("ValidationMessages");
    // }

    // @Bean
    // public LocaleResolver sessionLocaleResolver() {
    //     return new AcceptHeaderResolver();
    // }

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        UserGateway userGateway = new UserDatabaseGateway(userRepository);
        return new CreateUserUseCase(userGateway);
    }

}
