package com.vincle.dashboard_service.model;

import java.time.LocalDateTime;

public class NotificationPayload {
    private Long id;
    private String name;
    private String type;
    private boolean needsRefrigeration;
    private int capacity;
    private String container;
    private String createdBy;
    private LocalDateTime timestamp;
    private String status;
    private String message;

    // Getters y setters

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
