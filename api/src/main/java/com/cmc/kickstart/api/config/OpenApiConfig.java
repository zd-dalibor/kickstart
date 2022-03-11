package com.cmc.kickstart.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
    title = "KickStart API v1.0",
    description = "KickStart API v1.0",
    version = "1.0"
))
public class OpenApiConfig {
}
