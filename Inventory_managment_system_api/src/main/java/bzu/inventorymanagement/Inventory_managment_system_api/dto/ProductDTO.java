package bzu.inventorymanagement.Inventory_managment_system_api.dto;

import bzu.inventorymanagement.Inventory_managment_system_api.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private long productID;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Category category;
    private Set<String> shipmentIds;
    private Set<String> warehouseIds;
}
