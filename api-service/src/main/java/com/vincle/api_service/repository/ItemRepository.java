package com.vincle.api_service.repository;

import com.vincle.api_service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Aquí puedes agregar métodos de consulta personalizados si los necesitas en el futuro
}
