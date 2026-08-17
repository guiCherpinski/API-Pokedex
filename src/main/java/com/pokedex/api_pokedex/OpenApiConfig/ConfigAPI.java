package com.pokedex.api_pokedex.OpenApiConfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Api de Pokemon",
                version = "v1",
                description = "API didática sobre a Pokedex"
        )
)

@Configuration
public class ConfigAPI {
}
