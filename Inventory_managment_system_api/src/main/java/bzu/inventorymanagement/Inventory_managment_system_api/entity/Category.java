package bzu.inventorymanagement.Inventory_managment_system_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor   //automatically generates a constructor with a parameter for each field in your class
@NoArgsConstructor     // generates a constructor with no parameter
@Entity

@Table(name = "category")
public class Category implements Serializable {

    @Id
    private String categoryID;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
