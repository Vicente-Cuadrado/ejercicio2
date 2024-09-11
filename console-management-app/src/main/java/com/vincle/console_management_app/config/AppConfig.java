package com.vincle.console_management_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * RestTemplate para realizar llamadas HTTP a otros servicios.
 * 
 * @author Vicente Cuadrado
 */
@Configuration
public class AppConfig {

    /**
     * 
     * Definir el bean de RestTemplate
     * 
     * @return Instancia RestRTemplate 
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
