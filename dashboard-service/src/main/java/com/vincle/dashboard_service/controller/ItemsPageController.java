/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vincle.dashboard_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Controlador que gestiona las solicitudes para la página de items.
 *
 * @author Vicente Cuadrado
 */
@Controller
public class ItemsPageController {

    /**
     * *
     *
     * Maneja las solicitudes GET a la URL "/items".
     *
     * @return El nombre de la plantilla Thymeleaf "items" (sin la extensión
     * .html), que será procesada y renderizada.
     */
    @GetMapping("/items")
    public String itemsPage() {
        return "items";  // Nombre de tu plantilla Thymeleaf sin la extensión .html
    }
}
