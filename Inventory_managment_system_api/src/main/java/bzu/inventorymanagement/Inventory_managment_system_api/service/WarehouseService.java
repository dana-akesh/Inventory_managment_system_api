package bzu.inventorymanagement.Inventory_managment_system_api.service;

import bzu.inventorymanagement.Inventory_managment_system_api.dto.WarehouseDTO;

public interface WarehouseService {
    WarehouseDTO rewriteWarehouse(WarehouseDTO warehouseDTO); //put

    WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO);

    WarehouseDTO updateWarehouse(WarehouseDTO warehouseDTO, Long id);

    WarehouseDTO getWarehouseById(Long id);

    void deleteWarehouse(Long warehouseId);
}
