package com.openlab.h3_12.infrastructure.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Openlab API")
                        .version("1.0")
                        .description("""
                                **Openlab API Documentation**

                                Openlab es una plataforma para la colaboración y creación de startups 
                                mediante Organizaciones Autónomas Descentralizadas (DAO). Esta API 
                                permite a los usuarios:
                                """)
                        .termsOfService("https://github.com/No-Country-simulation/h3-12-openlab")
                )
                .components(
                        new Components()
                                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Autenticación mediante token JWT. Se debe incluir el token en el header Authorization con el formato: Bearer {token}")
                                )
                )
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
