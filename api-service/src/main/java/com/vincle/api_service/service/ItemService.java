package com.vincle.api_service.service;

import com.vincle.api_service.model.Item;
import com.vincle.api_service.model.NotificationPayload;
import com.vincle.api_service.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RestTemplate restTemplate;  // Para comunicarse con el dashboard-service

    private static final String DASHBOARD_SERVICE_URL = "http://localhost:8081/api/notify";  // URL del dashboard-service

    // Crear un nuevo item
    public Item createItem(Item item) throws IOException {
        prepareItemForProcessing(item, "WAITING");
        sendNotificationToDashboard(item, "Procesando creación de item");

        prepareItemForProcessing(item, "CREATED");
        item = itemRepository.save(item);
        sendNotificationToDashboard(item, "Item creado");
        return item;
    }

    // Obtener todos los items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Obtener un item por su ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Actualizar un item
    public Item updateItem(Long id, Item updatedItem) throws IOException {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item item = existingItem.get();

            prepareItemForProcessing(item, "WAITING");
            sendNotificationToDashboard(item, "Procesando actualización de item");

            item.setName(updatedItem.getName());
            item.setType(updatedItem.getType());
            item.setNeedsRefrigeration(updatedItem.isNeedsRefrigeration());
            item.setCapacity(updatedItem.getCapacity());
            item.setContainer(updatedItem.getContainer());
            item.setCreatedBy(updatedItem.getCreatedBy());

            prepareItemForProcessing(item, "UPDATED");

            item = itemRepository.save(item);
            sendNotificationToDashboard(item, "Item actualizado");
            return item;
        }
        return null;
    }

    // Eliminar un item
    public boolean deleteItem(Long id) throws IOException {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Item item = existingItem.get();

            prepareItemForProcessing(item, "WAITING");
            sendNotificationToDashboard(item, "Procesando eliminación de item");

            prepareItemForProcessing(item, "DELETED");
            item = itemRepository.save(item);
            sendNotificationToDashboard(item, "Item eliminado");
            return true;
        }
        return false;
    }

    // Método auxiliar para establecer estado y timestamp
    private void prepareItemForProcessing(Item item, String status) {
        item.setStatus(status);
        item.setTimestamp(LocalDateTime.now());
    }

    // Método auxiliar para enviar notificaciones al dashboard-service
    private void sendNotificationToDashboard(Item item, String message) throws IOException {
        NotificationPayload payload = new NotificationPayload(
                item.getId(), // ID del item
                item.getName(), // Nombre del item
                item.getType(), // Tipo del item
                item.isNeedsRefrigeration(), // Indica si necesita refrigeración
                item.getCapacity(), // Capacidad del item
                item.getContainer(), // Contenedor del item
                item.getCreatedBy(), // Persona que creó el item
                item.getTimestamp(), // Timestamp de creación o actualización
                item.getStatus(), // Estado actual del item (ej. CREATED, UPDATED)
                message // Mensaje adicional para la notificación
        );

        restTemplate.postForObject(DASHBOARD_SERVICE_URL, payload, Void.class);
    }
}
