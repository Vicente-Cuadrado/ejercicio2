package com.vincle.dashboard_service.config;

import java.util.Collections;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Donde se enviarán los mensajes
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/items")
                //.setAllowedOriginPatterns("*")
                // .setAllowedOriginPatterns("http://localhost:8081")
                // .setAllowedOrigins("*")
                // .setAllowedOrigins("http://localhost:8081");
                .withSockJS(); // Endpoint WebSocket para la página web
                // .setSessionCookieNeeded(false);  // Deshabilitar las credenciales (cookies de sesión)
    }
}
