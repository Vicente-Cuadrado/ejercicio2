package com.vincle.test_service.service;

import com.vincle.test_service.model.Item;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class ItemGeneratorService {

    private final Random random = new Random();

    // Método para generar un item aleatorio
    public Item generateRandomItem() {
        Item item = new Item();
        item.setName("Item " + random.nextInt(1000)); // Nombre aleatorio
        item.setType(random.nextBoolean() ? "Bebida" : "Comida"); // Tipo aleatorio
        item.setNeedsRefrigeration(random.nextBoolean()); // Necesidad de refrigeración aleatoria
        item.setCapacity(random.nextInt(1000)); // Capacidad aleatoria en gramos
        item.setContainer(random.nextBoolean() ? "Botella" : "Caja"); // Tipo de contenedor aleatorio
        item.setCreatedBy("AutomatedTest"); // Creador automático
        item.setTimestamp(LocalDateTime.now()); // Timestamp actual
        item.setStatus("CREATED"); // Estado inicial
        return item;
    }
}
