package bzu.inventorymanagement.Inventory_managment_system_api.repository;

import bzu.inventorymanagement.Inventory_managment_system_api.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
