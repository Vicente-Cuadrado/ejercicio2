package com.vincle.test_service.service;

import com.vincle.test_service.model.Item;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * Servicio encargado de generar items aleatorios.
 *
 * Esta clase se utiliza para crear instancias de items con propiedades
 * generadas de manera aleatoria.
 *
 * @author Vicente Cuadrado
 */
@Service
public class ItemGeneratorService {

    private final Random random = new Random();

    // Array de tipos de productos
    private static final String[] TYPES = {"BEBIDA", "COMIDA", "SALSAS", "ESPECIES"};

    /**
     *
     * Método para generar un item con valores aleatorios.
     *
     * @return Item con valores generados aleatoriamente.
     */
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

    /**
     * Método privado que selecciona aleatoriamente un tipo de item.
     *
     * @return Un tipo aleatorio desde el array de tipos ("BEBIDA", "COMIDA",
     * "SALSAS", "ESPECIES").
     */
    private String getRandomType() {
        int index = random.nextInt(TYPES.length);
        return TYPES[index];
    }

}
