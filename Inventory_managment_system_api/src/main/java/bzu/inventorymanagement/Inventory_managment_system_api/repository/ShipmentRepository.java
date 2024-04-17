package bzu.inventorymanagement.Inventory_managment_system_api.repository;

import bzu.inventorymanagement.Inventory_managment_system_api.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
