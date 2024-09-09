package com.vincle.api_service.controller;

import com.vincle.api_service.model.Item;
import com.vincle.api_service.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
@Tag(name = "Item API", description = "API para la gestión de items")  // Etiqueta de la API
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Operation(summary = "Crear un nuevo item")  // Documentación del endpoint
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @Operation(summary = "Obtener todos los items")  // Documentación del endpoint
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @Operation(summary = "Obtener un item por ID")  // Documentación del endpoint
    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @Operation(summary = "Actualizar un item existente")  // Documentación del endpoint
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        return itemService.updateItem(id, updatedItem);
    }

    @Operation(summary = "Eliminar un item por ID")  // Documentación del endpoint
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
