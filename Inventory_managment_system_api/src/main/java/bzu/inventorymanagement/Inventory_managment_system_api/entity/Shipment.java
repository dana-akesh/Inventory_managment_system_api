package bzu.inventorymanagement.Inventory_managment_system_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor   //automatically generates a constructor with a parameter for each field in your class
@NoArgsConstructor     // generates a constructor with no parameter
@Entity

@Table(name = "shipment")
public class Shipment {

    @Id
    private long shipmentID;
    private String status;
    private String trackingNumber;

    @ManyToMany(mappedBy = "shipment")
    private Set<Product> product;

    @ManyToMany
    private Set<Warehouse> warehouse;
}