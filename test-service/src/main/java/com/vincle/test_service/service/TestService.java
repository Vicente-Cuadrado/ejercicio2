package com.vincle.test_service.service;

import com.vincle.test_service.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class TestService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ItemGeneratorService itemGeneratorService;

    private static final String API_URL = "http://localhost:8080/api/items";
    private Random random = new Random();

    // Bucle que genera N operaciones aleatorias
    public void performRandomOperations(int numberOfOperations) {
        for (int i = 0; i < numberOfOperations; i++) {
            int operation = random.nextInt(3); // 0 = create, 1 = update, 2 = delete

            switch (operation) {
                case 0:
                    createRandomItem();
                    break;
                case 1:
                    updateRandomItem(getRandomItemId()); // Reemplaza con una lógica para obtener un ID válido
                    break;
                case 2:
                    deleteRandomItem(getRandomItemId()); // Reemplaza con una lógica para obtener un ID válido
                    break;
            }

            // Añadir un pequeño delay si es necesario para observar mejor los logs
            try {
                Thread.sleep(1000); // 1 segundo de espera
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Método para crear un item aleatorio en la API
    public void createRandomItem() {
        Item item = itemGeneratorService.generateRandomItem();
        restTemplate.postForObject(API_URL, item, Item.class);
        System.out.println("Item creado: " + item.getName());
    }

    // Método para actualizar un item aleatorio en la API
    public void updateRandomItem(Long itemId) {
        if (itemId != null) {
            Item updatedItem = itemGeneratorService.generateRandomItem();
            restTemplate.put(API_URL + "/" + itemId, updatedItem);
            System.out.println("Item actualizado con ID: " + itemId);
        }
    }

    // Método para eliminar un item aleatorio de la API
    public void deleteRandomItem(Long itemId) {
        if (itemId != null) {
            restTemplate.delete(API_URL + "/" + itemId);
            System.out.println("Item eliminado con ID: " + itemId);
        }
    }

    // Lógica para obtener un ID aleatorio de un item existente
    private Long getRandomItemId() {
        Item[] items = restTemplate.getForObject(API_URL, Item[].class);
        if (items != null && items.length > 0) {
            return items[random.nextInt(items.length)].getId(); // Selecciona un ID aleatorio de un item existente
        }
        return null; // Si no hay items disponibles
    }
}
