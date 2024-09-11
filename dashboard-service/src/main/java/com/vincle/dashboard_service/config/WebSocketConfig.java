package com.vincle.dashboard_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 *
 * Configuración de WebSocket para la aplicación del dashboard.
 *
 * sta clase configura el soporte para la mensajería basada en WebSocket
 * utilizando STOMP (Streaming Text Oriented Messaging Protocol).
 *
 * @author Vicente Cuadrado
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 
     * Configura el Message Broker que maneja los mensajes salientes.
     * 
     * @param config Permite configurar el broker de mensajes.
     
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Donde se enviarán los mensajes
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 
     * Registra el endpoint de STOMP que los clientes utilizarán para conectarse a la aplicación WebSocket.
     * 
     * @param registry Permite registrar los endpoints de WebSocket.
     */
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
