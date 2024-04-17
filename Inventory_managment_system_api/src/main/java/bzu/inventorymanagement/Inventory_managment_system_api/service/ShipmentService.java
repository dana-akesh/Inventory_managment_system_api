package bzu.inventorymanagement.Inventory_managment_system_api.service;

import bzu.inventorymanagement.Inventory_managment_system_api.dto.ShipmentDTO;

public interface ShipmentService {
    ShipmentDTO rewriteShipment(ShipmentDTO shipmentDTO); //put

    ShipmentDTO createShipment(ShipmentDTO shipmentDTO);

    ShipmentDTO updateShipment(ShipmentDTO shipmentDTO, Long id);

    ShipmentDTO getShipmentById(Long id);

    void deleteShipment(Long id);
}
