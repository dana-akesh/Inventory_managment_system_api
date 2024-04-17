package bzu.inventorymanagement.Inventory_managment_system_api.dto;

import bzu.inventorymanagement.Inventory_managment_system_api.entity.Product;
import bzu.inventorymanagement.Inventory_managment_system_api.entity.Shipment;
import bzu.inventorymanagement.Inventory_managment_system_api.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDTO {

    private Long warehouseid;
    private String name;
    private String location;
    private int capacity;
    private Set<Product> products;
    private Set<Shipment> shipments;
}
