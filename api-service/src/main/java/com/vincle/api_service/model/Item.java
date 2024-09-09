package com.vincle.api_service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Schema(description = "Representa un item con todas sus propiedades")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del item", example = "1", required = true)
    private Long id;  // Identificador único

    @Column(nullable = false)
    @Schema(description = "Nombre del item", example = "Coca-Cola", required = true)
    private String name;  // Nombre del item

    @Column(nullable = false)
    @Schema(description = "Tipo de item (bebida, comida, etc.)", example = "bebida", required = true)
    private String type;  // Tipo de item (bebida, comida, etc.)

    @Column(name = "needs_refrigeration", nullable = false)
    @Schema(description = "Indica si el item necesita refrigeración", example = "true", required = true)
    private boolean needsRefrigeration;  // Si necesita refrigeración

    @Column(nullable = false)
    @Schema(description = "Capacidad en gramos (100 gr o 1000 gr)", example = "100", required = true)
    private int capacity;  // Capacidad en gramos (100 gr o 1000 gr)

    @Column(nullable = false)
    @Schema(description = "Tipo de envase (botella o caja)", example = "botella", required = true)
    private String container;  // Tipo de envase (botella o caja)

    @Column(name = "created_by", nullable = false)
    @Schema(description = "Cliente que creó el item", example = "TestClient", required = true)
    private String createdBy;  // Cliente que creó el item

    @Column(nullable = false)
    @Schema(description = "Fecha y hora de creación o modificación", example = "2023-09-01T12:30:00", required = true)
    private LocalDateTime timestamp;  // Fecha y hora de creación o modificación

    @Column(nullable = false)
    @Schema(description = "Estado del item (WAITING, CREATED, DELETED)", example = "CREATED", required = true)
    private String status;  // Estado del item (WAITING, CREATED, DELETED)

    // Constructor vacío
    public Item() {}

    // Constructor con todos los campos
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
