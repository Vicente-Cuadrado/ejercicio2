package com.vincle.test_service.controller;

import com.vincle.test_service.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Controlador que expone endpoints para realizar operaciones de prueba sobre
 * items (crear, actualizar, eliminar). Permite a través de solicitudes HTTP
 * realizar operaciones CRUD de manera aleatoria en la API.
 *
 * @author Vicente Cuadrado
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService; // Servicio que realiza las operaciones sobre los items.

    /**
     *
     * Endpoint que crea un item aleatorio. Se accede a través de una solicitud
     *
     * GET a "/test/create".
     */
    @GetMapping("/test/create")
    public void createItem() {
        testService.createRandomItem();
    }

    /**
     *
     * Endpoint que actualiza un item aleatorio con un ID especificado. Se
     * accede a través de una solicitud GET a "/test/update/{id}".
     *
     * @param id El ID del item que se desea actualizar.
     */
    @GetMapping("/test/update/{id}")
    public void updateItem(@PathVariable Long id) {
        testService.updateRandomItem(id);
    }

    /**
     * Endpoint que elimina un item aleatorio con un ID especificado. Se accede
     * a través de una solicitud GET a "/test/delete/{id}".
     *
     * @param id El ID del item que se desea eliminar.
     */
    @GetMapping("/test/delete/{id}")
    public void deleteItem(@PathVariable Long id) {
        testService.deleteRandomItem(id);
    }
}
