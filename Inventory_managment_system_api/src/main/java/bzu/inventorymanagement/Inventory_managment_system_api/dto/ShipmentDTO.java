package bzu.inventorymanagement.Inventory_managment_system_api.dto;

import bzu.inventorymanagement.Inventory_managment_system_api.entity.Product;
import bzu.inventorymanagement.Inventory_managment_system_api.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDTO {

    private Long shipmentid;
    private String status;
    private String tracking_number;
    private Set<Product> products;
    private Set<Warehouse> warehouses;
}
