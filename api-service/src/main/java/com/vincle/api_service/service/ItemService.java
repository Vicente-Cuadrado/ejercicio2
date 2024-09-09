package com.vincle.api_service.service;

import com.vincle.api_service.model.Item;
import com.vincle.api_service.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        item.setTimestamp(java.time.LocalDateTime.now());  // Establecer la fecha de creación
        item.setStatus("CREATED");  // Estado inicial como 'CREATED'
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item updateItem(Long id, Item updatedItem) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setName(updatedItem.getName());
            item.setType(updatedItem.getType());
            item.setNeedsRefrigeration(updatedItem.isNeedsRefrigeration());
            item.setCapacity(updatedItem.getCapacity());
            item.setContainer(updatedItem.getContainer());
            item.setCreatedBy(updatedItem.getCreatedBy());
            item.setTimestamp(java.time.LocalDateTime.now());  // Actualizar el timestamp
            item.setStatus("UPDATED");  // Cambiar estado a 'UPDATED'
            return itemRepository.save(item);
        } else {
            throw new RuntimeException("Item no encontrado");
        }
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
