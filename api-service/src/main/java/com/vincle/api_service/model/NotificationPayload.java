package com.vincle.api_service.model;

import java.time.LocalDateTime;

/**
 * 
 * Clase que representa el payload que se enviará como notificación
 * al dashboard-service o a otros servicios en la arquitectura de microservicios.
 * Contiene todos los detalles del Item.
 * 
 * @author Vicente Cuadrado
 * 
 */
public class NotificationPayload {

    // Atributos del Item que se incluirán en la notificación
    private Long id;                   // ID del item
    private String name;               // Nombre del item
    private String type;               // Tipo del item (ej. alimento, bebida)
    private boolean needsRefrigeration; // Indica si necesita refrigeración
    private int capacity;              // Capacidad del item
    private String container;          // Tipo de contenedor del item
    private String createdBy;          // Persona que creó el item
    private LocalDateTime timestamp;   // Marca temporal de creación o actualización
    private String status;             // Estado actual del item (ej. CREATED, UPDATED, DELETED)
    private String message;            // Mensaje adicional para la notificación

    /**
     * Constructor que inicializa todos los campos de la notificación.
     *
     * @param id                ID del item
     * @param name              Nombre del item
     * @param type              Tipo de item
     * @param needsRefrigeration Si necesita refrigeración
     * @param capacity          Capacidad del item
     * @param container         Contenedor del item
     * @param createdBy         Persona que creó el item
     * @param timestamp         Timestamp del evento
     * @param status            Estado actual del item
     * @param message           Mensaje de notificación
     */
    public NotificationPayload(Long id, String name, String type, boolean needsRefrigeration, int capacity, String container, String createdBy, LocalDateTime timestamp, String status, String message) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.needsRefrigeration = needsRefrigeration;
        this.capacity = capacity;
        this.container = container;
        this.createdBy = createdBy;
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    // Getters y setters para acceder y modificar los atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNeedsRefrigeration() {
        return needsRefrigeration;
    }

    public void setNeedsRefrigeration(boolean needsRefrigeration) {
        this.needsRefrigeration = needsRefrigeration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
