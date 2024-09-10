package com.vincle.test_service.controller;

import com.vincle.test_service.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    // Endpoint para crear un item aleatorio
    @GetMapping("/test/create")
    public void createItem() {
        testService.createRandomItem();
    }


    // Endpoint para actualizar un item aleatorio
    @GetMapping("/test/update/{id}")
    public void updateItem(@PathVariable Long id) {
        testService.updateRandomItem(id);
    }

    // Endpoint para eliminar un item aleatorio
    @GetMapping("/test/delete/{id}")
    public void deleteItem(@PathVariable Long id) {
        testService.deleteRandomItem(id);
    }
}
