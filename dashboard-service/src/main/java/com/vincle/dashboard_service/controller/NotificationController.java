package com.vincle.dashboard_service.controller;

import com.vincle.dashboard_service.model.NotificationPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Controlador que maneja las notificaciones enviadas desde otros servicios (por ejemplo, api-service).
 * Se encarga de recibir notificaciones y retransmitirlas a los clientes suscritos mediante WebSocket. 
 * 
 * @author Vicente Cuadrado
 */
@RestController
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate; // Herramienta para enviar mensajes a los clientes WebSocket

    /**
     * 
     * Endpoint para recibir notificaciones de otros servicios a través de una solicitud HTTP POST.
     * 
     * @param payload Objeto NotificationPayload que contiene los detalles de la notificación.
     */    
    @PostMapping("/api/notify")
    public void receiveNotification(@RequestBody NotificationPayload payload) {
        // Procesar la notificación recibida
        System.out.println("Notificación recibida:");
        System.out.println("ID: " + payload.getId());
        System.out.println("Nombre: " + payload.getName());
        System.out.println("Estado: " + payload.getStatus());
        System.out.println("Mensaje: " + payload.getMessage());

        // Enviar la notificación a través del WebSocket a todos los clientes
        messagingTemplate.convertAndSend("/topic/items", payload);
    }
}
