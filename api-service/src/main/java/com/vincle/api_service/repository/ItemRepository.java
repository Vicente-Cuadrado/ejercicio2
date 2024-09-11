package com.vincle.api_service.repository;

import com.vincle.api_service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * Repositorio para la entidad Item.
 * 
 * @author Vicente Cuadrado
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Agregar métodos de consulta personalizados si los necesitas en el futuro
}
