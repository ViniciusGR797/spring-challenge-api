package com.challengepay.challengepay.infra.config.beans;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI()
            .info(new Info()
                .version("v1.0.0")
                .title("API RESTful - SpringChallenge")
                .description("Este projeto consiste na construção de uma **API RESTful usando o framework Spring Boot** com **Clean Architecture, Princípios de SOLID, Design Pattern, SpringDoc OpenApi UI, Docker e Testes** para criar um sistema pagamentos simplificado." +
                            "\n\nA API fornecerá aos usuários todas as funcionalidades necessárias para gerenciar seu perfil e realizar transferências bancárias **entre usuários e comerciantes** ou **entre usuários**. Além disso, ela será projetada para **garantir a segurança e a privacidade dos dados do usuário**, utilizando práticas de autenticação e autorização apropriadas." +
                            "\n\nO uso do SpringDoc OpenApi UI facilitou a **documentação Swagger completa de cada endpoint da Api**, além do uso de Clean Archicture, tornando o processo de **desenvolvimento mais eficiente e organizado.**" +
                            "\n\nEm suma, o objetivo deste software é **aplicar boas práticas de codificação, arquitetura, documentação de software, testes unitários e funcionais**, consolidando os aprendizados adquiridos. Através de uma API robusta construída com Spring Boot, esperamos fornecer uma solução segura, escalável, eficiente, de fácil manutenção e com documentação completa.")
                .license(new License()
                    .name("License MIT")
                    .url("https://github.com/ViniciusGR797/spring-challenge-api/blob/master/LICENSE")    
                )
            )
            .components(new Components()
                .addSecuritySchemes("bearer-jwt", new SecurityScheme()
                    .type(SecurityScheme.Type.APIKEY)
                    .scheme("bearer")
                    .bearerFormat("JWT")
                    .in(SecurityScheme.In.HEADER)
                    .name("Authorization")
                    .description("To authenticate, put the JWT token in the format **Bearer &lt;token&gt;**.")
                )
            )
            .security(Arrays.asList(new SecurityRequirement().addList("bearer-jwt")));
    }
    
}
