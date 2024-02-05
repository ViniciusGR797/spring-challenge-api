package com.challengepay.challengepay.infra.config.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI()
            .info(new Info()
                .version("1.0.0")
                .title("API")
                .description("Descrição")
                .license(new License()
                    .name("License MIT")
                    .url("github")    
                )
            );
    }
    
}
