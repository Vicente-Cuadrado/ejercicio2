package com.vincle.test_service.service;

import com.vincle.test_service.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * Servicio encargado de realizar operaciones de prueba (crear, actualizar,
 * eliminar items) en la API. Este servicio utiliza RestTemplate para
 * interactuar con la API de items y realiza operaciones de manera aleatoria.
 *
 * @author Vicente Cuadrado
 *
 */
@Service
public class TestService {

    @Autowired
    private RestTemplate restTemplate; // Cliente HTTP para interactuar con la API externa

    @Autowired
    private ItemGeneratorService itemGeneratorService; // Servicio para generar items aleatorios

    @Value("${api.service.url}") // URL de la API cargada desde el archivo de propiedades
    private String API_URL;

    // private static final String API_URL = "http://localhost:8080/api/items";
    // private static final String API_URL = "http://api-service:8080/api/items";
    private Random random = new Random(); // Instancia de Random para generar valores aleatorios

    /**
     *
     * Bucle que realiza un número determinado de operaciones aleatorias sobre
     * la API.
     *
     * @param numberOfOperations Número de operaciones a realizar.
     */
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

    /**
     *
     * Método que crea un item aleatorio y lo envía a la API para guardarlo.
     *
     */
    public void createRandomItem() {
        Item item = itemGeneratorService.generateRandomItem();
        restTemplate.postForObject(API_URL, item, Item.class);
        System.out.println("Item creado: " + item.getName());
    }

    /**
     *
     * Método que actualiza un item existente de forma aleatoria.
     *
     * @param itemId El ID del item que se va a actualizar.
     */
    public void updateRandomItem(Long itemId) {
        if (itemId != null) {
            Item updatedItem = itemGeneratorService.generateRandomItem();
            restTemplate.put(API_URL + "/" + itemId, updatedItem);
            System.out.println("Item actualizado con ID: " + itemId);
        }
    }

    /**
     *
     * Método que elimina un item existente en la API.
     *
     * @param itemId El ID del item que se va a eliminar.
     */
    public void deleteRandomItem(Long itemId) {
        if (itemId != null) {
            restTemplate.delete(API_URL + "/" + itemId);
            System.out.println("Item eliminado con ID: " + itemId);
        }
    }

    /**
     * 
     * Método que obtiene un ID aleatorio de un item existente en la API.
     *
     * @return El ID de un item aleatorio, o null si no hay items disponibles.
     */
    private Long getRandomItemId() {
        Item[] items = restTemplate.getForObject(API_URL, Item[].class);
        if (items != null && items.length > 0) {
            return items[random.nextInt(items.length)].getId(); // Selecciona un ID aleatorio de un item existente
        }
        return null; // Si no hay items disponibles
    }
}
