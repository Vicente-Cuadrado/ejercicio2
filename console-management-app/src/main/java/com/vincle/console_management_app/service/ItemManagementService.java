package com.vincle.console_management_app.service;

import com.vincle.console_management_app.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ItemManagementService {

    @Autowired
    private RestTemplate restTemplate;

    private final String apiUrl = "http://api-service:8080/api/items";  // Cambia la URL según tu entorno

    public Item[] getAllItems() {
        return restTemplate.getForObject(apiUrl, Item[].class);
    }

    public Item createItem(Item item) {
        return restTemplate.postForObject(apiUrl, item, Item.class);
    }

    public void updateItem(Long id, Item item) {
        restTemplate.put(apiUrl + "/" + id, item);
    }

    public void deleteItem(Long id) {
        restTemplate.delete(apiUrl + "/" + id);
    }
}
