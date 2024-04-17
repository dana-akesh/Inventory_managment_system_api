package bzu.inventorymanagement.Inventory_managment_system_api.dto;

import bzu.inventorymanagement.Inventory_managment_system_api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private String categoryID;
    private String name;
    private String description;
    private Set<Product> products;
}
