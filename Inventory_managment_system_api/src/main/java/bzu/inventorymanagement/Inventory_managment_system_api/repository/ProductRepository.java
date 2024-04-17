package bzu.inventorymanagement.Inventory_managment_system_api.repository;

import bzu.inventorymanagement.Inventory_managment_system_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
