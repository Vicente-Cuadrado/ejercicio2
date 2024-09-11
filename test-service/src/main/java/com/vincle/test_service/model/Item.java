package com.vincle.test_service.model;

import java.time.LocalDateTime;

/**
 * Clase que representa un Item con todas sus propiedades.
 * Se utiliza en la aplicación de consola para gestionar la creación, actualización, 
 * eliminación y listado de Items.
 * 
 * @author Vicente Cuadrado
 * 
 */
public class Item {

    /**
     * Identificador único del item.
     */
    private Long id;

    /**
     * Nombre del item.
     */
    private String name;

    /**
     * Tipo de item (bebida, comida, etc.).
     */
    private String type;

    /**
     * Indica si el item necesita refrigeración.
     */
    private boolean needsRefrigeration;

    /**
     * Capacidad en gramos (100 gr o 1000 gr).
     */
    private int capacity;

    /**
     * Tipo de envase (botella o caja).
     */
    private String container;

    /**
     * Nombre del cliente que creó el item.
     */
    private String createdBy;

    /**
     * Fecha y hora de creación o modificación del item.
     */
    private LocalDateTime timestamp;

    /**
     * Estado actual del item (WAITING, CREATED, UPDATED, DELETED).
     */
    private String status;

    /**
     * Constructor vacío necesario para la serialización.
     */
    public Item() {}

    /**
     * Constructor con todos los parámetros necesarios para crear un item.
     * 
     * @param name El nombre del item.
     * @param type El tipo de item (bebida, comida, etc.).
     * @param needsRefrigeration Indica si el item necesita refrigeración.
     * @param capacity La capacidad del item en gramos (100 gr o 1000 gr).
     * @param container El tipo de envase (botella o caja).
     * @param createdBy El nombre del cliente que creó el item.
     * @param timestamp La fecha y hora de creación o modificación.
     * @param status El estado actual del item (CREATED, UPDATED, DELETED).
     */
    public Item(String name, String type, boolean needsRefrigeration, int capacity, 
                String container, String createdBy, LocalDateTime timestamp, String status) {
        this.name = name;
        this.type = type;
        this.needsRefrigeration = needsRefrigeration;
        this.capacity = capacity;
        this.container = container;
        this.createdBy = createdBy;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Getters y Setters

    /**
     * Retorna el identificador único del item.
     * 
     * @return El ID del item.
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador único del item.
     * 
     * @param id El ID del item.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el nombre del item.
     * 
     * @return El nombre del item.
     */
    public String getName() {
        return name;
    }

    /**
     * Asigna el nombre del item.
     * 
     * @param name El nombre del item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna el tipo de item (bebida, comida, etc.).
     * 
     * @return El tipo de item.
     */
    public String getType() {
        return type;
    }

    /**
     * Asigna el tipo de item (bebida, comida, etc.).
     * 
     * @param type El tipo de item.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retorna si el item necesita refrigeración.
     * 
     * @return true si necesita refrigeración, false de lo contrario.
     */
    public boolean isNeedsRefrigeration() {
        return needsRefrigeration;
    }

    /**
     * Asigna si el item necesita refrigeración.
     * 
     * @param needsRefrigeration true si necesita refrigeración, false de lo contrario.
     */
    public void setNeedsRefrigeration(boolean needsRefrigeration) {
        this.needsRefrigeration = needsRefrigeration;
    }

    /**
     * Retorna la capacidad del item en gramos.
     * 
     * @return La capacidad del item.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Asigna la capacidad del item en gramos.
     * 
     * @param capacity La capacidad del item.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Retorna el tipo de envase del item (botella o caja).
     * 
     * @return El tipo de envase.
     */
    public String getContainer() {
        return container;
    }

    /**
     * Asigna el tipo de envase del item (botella o caja).
     * 
     * @param container El tipo de envase.
     */
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * Retorna el nombre del cliente que creó el item.
     * 
     * @return El nombre del cliente.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Asigna el nombre del cliente que creó el item.
     * 
     * @param createdBy El nombre del cliente.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Retorna la fecha y hora de creación o modificación del item.
     * 
     * @return El timestamp del item.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Asigna la fecha y hora de creación o modificación del item.
     * 
     * @param timestamp El timestamp del item.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Retorna el estado actual del item (CREATED, UPDATED, DELETED).
     * 
     * @return El estado del item.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Asigna el estado actual del item (CREATED, UPDATED, DELETED).
     * 
     * @param status El estado del item.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Devuelve una representación en cadena del item, con todos sus atributos.
     * 
     * @return La representación en cadena del item.
     */
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", needsRefrigeration=" + needsRefrigeration +
                ", capacity=" + capacity +
                ", container='" + container + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }
}
