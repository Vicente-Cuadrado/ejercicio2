/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vincle.dashboard_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemsPageController {

    @GetMapping("/items")
    public String itemsPage() {
        return "items";  // Nombre de tu plantilla Thymeleaf sin la extensión .html
    }
}
