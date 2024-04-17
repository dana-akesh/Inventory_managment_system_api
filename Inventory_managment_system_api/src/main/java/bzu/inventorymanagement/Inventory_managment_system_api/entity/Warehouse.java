package bzu.inventorymanagement.Inventory_managment_system_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor   //automatically generates a constructor with a parameter for each field in your class
@NoArgsConstructor     // generates a constructor with no parameter
@Entity

@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long warehouseid;
    private String name;
    private String location;
    private int capacity;

    @ManyToMany(mappedBy = "warehouse")
    private Set<Product> product;

    @ManyToMany(mappedBy = "warehouse")
    private Set<Shipment> shipment;
}