package com.vincle.test_service.service;

import com.vincle.test_service.model.Item;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class ItemGeneratorService {

    private final Random random = new Random();

    // Array de tipos de productos
    private static final String[] TYPES = {"BEBIDA", "COMIDA", "SALSAS", "ESPECIES"};

    // Método para generar un item aleatorio
    public Item generateRandomItem() {
        Item item = new Item();
        item.setName("Item " + random.nextInt(1000)); // Nombre aleatorio
        item.setType(getRandomType()); // Tipo aleatorio entre "bebida", "comida", "salsas", "especies"
        item.setNeedsRefrigeration(random.nextBoolean()); // Necesidad de refrigeración aleatoria
        item.setCapacity(random.nextBoolean() ? 100 : 1000); // Capacidad aleatoria en gramos
        item.setContainer(random.nextBoolean() ? "BOTELLA" : "CAJA"); // Tipo de contenedor aleatorio
        item.setCreatedBy("AUTOMATED TEST"); // Creador automático
        item.setTimestamp(LocalDateTime.now()); // Timestamp actual
        item.setStatus("CREATED"); // Estado inicial
        return item;
    }

    // Método para obtener un tipo aleatorio
    private String getRandomType() {
        int index = random.nextInt(TYPES.length);
        return TYPES[index];
    }

}
