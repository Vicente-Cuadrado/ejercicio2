package com.vincle.dashboard_service.model;

import java.time.LocalDateTime;

/**
 * Clase que representa el payload de una notificación. Se utiliza para
 * encapsular los detalles de un item y un mensaje que se envía como parte de la
 * notificación.
 *
 * @author Vicente Cuadrado.
 */
public class NotificationPayload {

    private Long id;  // Identificador único del item
    private String name;  // Nombre del item
    private String type;  // Tipo del item (bebida, comida, etc.)
    private boolean needsRefrigeration;  // Indica si el item necesita refrigeración
    private int capacity;  // Capacidad del item en gramos
    private String container;  // Tipo de envase (botella o caja)
    private String createdBy;  // Nombre del cliente que creó el item
    private LocalDateTime timestamp;  // Fecha y hora de creación o modificación del item
    private String status;  // Estado actual del item (CREATED, UPDATED, DELETED)
    private String message;  // Mensaje adicional para notificaciones

    /**
     * Obtiene el identificador único del item.
     *
     * @return El ID del item.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del item.
     *
     * @param id El ID del item.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del item.
     *
     * @return El nombre del item.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del item.
     *
     * @param name El nombre del item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el tipo de item (bebida, comida, etc.).
     *
     * @return El tipo de item.
     */
    public String getType() {
        return type;
    }

    /**
     * Establece el tipo de item (bebida, comida, etc.).
     *
     * @param type El tipo de item.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Indica si el item necesita refrigeración.
     *
     * @return true si el item necesita refrigeración, false en caso contrario.
     */
    public boolean isNeedsRefrigeration() {
        return needsRefrigeration;
    }

    /**
     * Establece si el item necesita refrigeración.
     *
     * @param needsRefrigeration true si necesita refrigeración, false en caso
     * contrario.
     */
    public void setNeedsRefrigeration(boolean needsRefrigeration) {
        this.needsRefrigeration = needsRefrigeration;
    }

    /**
     * Obtiene la capacidad del item en gramos.
     *
     * @return La capacidad del item.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Establece la capacidad del item en gramos.
     *
     * @param capacity La capacidad del item.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Obtiene el tipo de envase del item (botella o caja).
     *
     * @return El tipo de envase.
     */
    public String getContainer() {
        return container;
    }

    /**
     * Establece el tipo de envase del item (botella o caja).
     *
     * @param container El tipo de envase.
     */
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * Obtiene el nombre del cliente que creó el item.
     *
     * @return El nombre del cliente.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Establece el nombre del cliente que creó el item.
     *
     * @param createdBy El nombre del cliente.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Obtiene la fecha y hora de creación o modificación del item.
     *
     * @return El timestamp del item.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Establece la fecha y hora de creación o modificación del item.
     *
     * @param timestamp El timestamp del item.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Obtiene el estado actual del item (CREATED, UPDATED, DELETED).
     *
     * @return El estado del item.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Establece el estado actual del item (CREATED, UPDATED, DELETED).
     *
     * @param status El estado del item.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtiene el mensaje adicional para la notificación.
     *
     * @return El mensaje de la notificación.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece un mensaje adicional para la notificación.
     *
     * @param message El mensaje de la notificación.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
