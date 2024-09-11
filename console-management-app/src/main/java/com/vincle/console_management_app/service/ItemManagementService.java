package com.vincle.console_management_app.service;

import com.vincle.console_management_app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Servicio que gestiona las operaciones CRUD (Crear, Leer, Actualizar,
 * Eliminar) para los items.
 *
 * Este servicio interactúa con una API externa utilizando RestTemplate para
 * enviar y recibir datos.
 *
 * @author Vicente Cuadrado
 */
@Service
public class ItemManagementService {

    @Autowired
    private RestTemplate restTemplate; // Inyecta RestTemplate para realizar llamadas HTTP

    @Value("${api.service.url}") // Inyecta la URL de la API desde el archivo application.properties
    private String apiUrl;
    // private final String apiUrl = "http://api-service:8080/api/items";  // Cambia la URL según tu entorno
    // private final String apiUrl = "http://localhost:8080/api/items";  // Cambia la URL según tu entorno

    /**
     *
     * Obtiene todos los items desde la API.
     *
     * @return Un array de items obtenidos de la API.
     */
    public Item[] getAllItems() {
        return restTemplate.getForObject(apiUrl, Item[].class);
    }

    /**
     * Crea un nuevo item en la API.
     *
     * @param item El item que se va a crear.
     * @return El item creado, devuelto por la API.
     */
    public Item createItem(Item item) {
        return restTemplate.postForObject(apiUrl, item, Item.class);
    }

    /**
     * Actualiza un item existente en la API.
     *
     * @param id El ID del item que se va a actualizar.
     * @param item El objeto Item con los nuevos datos.
     */
    public void updateItem(Long id, Item item) {
        restTemplate.put(apiUrl + "/" + id, item);
    }

    /**
     * Elimina un item de la API.
     *
     * @param id El ID del item que se va a eliminar.
     */
    public void deleteItem(Long id) {
        restTemplate.delete(apiUrl + "/" + id);
    }
}
