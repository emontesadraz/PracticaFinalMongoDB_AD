package org.example.repasotarea5.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración de Swagger
 * @version 1.0, 16/09/21
 * @autor Esteban Montes
 */
@Configuration
public class SwaggerConfig {

    @Value("${spring.application.version}") // Inyecta el valor de la propiedad spring.application.version
    private String version;

    @Value("${spring.application.name}") // Inyecta el valor de la propiedad spring.application.name
    private String appName;

    /**
     * Método que crea un objeto OpenAPI con la información de la aplicación
     * @return OpenAPI
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(appName)
                        .description("Tarea 5 de acceso a datos de mongoService")
                        .version(version));
    }
}
