package com.vincle.api_service.controller;

import com.vincle.api_service.model.Item;
import com.vincle.api_service.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Controlador REST para la gestión de items.
 * 
 * @author Vicente Cuadrado
 */
@RestController
@RequestMapping("/api/items")
@Tag(name = "Item API", description = "API para la gestión de items")  // Etiqueta de la API
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Operation(summary = "Crear un nuevo item")  // Documentación del endpoint
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        try {
            return itemService.createItem(item);
        } catch (IOException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
        try {
            return itemService.updateItem(id, updatedItem);
        } catch (IOException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Operation(summary = "Eliminar un item por ID")  // Documentación del endpoint
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        try {
            itemService.deleteItem(id);
        } catch (IOException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
