# ⭐ Inventory Managment System Rest API ⭐
The Inventory Management System API provides endpoints for managing inventory-related operations within a business or organization.With the use of _OpenAi 3.1.0_ it allows the user to add, update, and delete the core reasources which are the products, categories, warehouses, and shipments.
## 🔖Table Of Contents:
- [Core Resources](#core-resources)
- [ER Diagram](#er-diagram)
- [Design and Documentation Tables for the Core Resources](#design-and-documentation-tables-for-the-core-resources)
- [Swagger Hub Link](#swagger-hub-link)
## 💡Core Resources:
<ol>
  <li>
    <b>Products: </b> 
    The items that are managed by the inventory system, and it has an ID, description, name, price, and quantity.
  </li>
  <li>
    <b>Categories:</b>
    The groups of a particular products that have similar attributes, and to organize the inventory.
  </li>
  <li>
    <b>Warehouses: </b>
    The place where the items are stored, and it has an address, capacity, and name.
  </li>
  <li>
    <b>Shipments: </b>
    To follow up with the movement of products between locations with details on quantity, status, and tracking number.
  </li>
</ol>

## 💠ER Diagram:
![ER_Diagram drawio](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/cfc080e9-bf7e-41d0-9d13-de69df9503b0)

## 🪄Design and Documentation Tables for the Core Resources:
### /products 
![image](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/ec19af17-add6-48c2-bba8-e641452db013)

### /categories
![image](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/4df467a6-2212-4b86-9526-a9498d8eb0dc)

### /warehouses
![image](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/72f17efa-b8c2-4cc0-9957-157c293146c9)

### /shipments
![image](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/ab56914f-7c04-4c44-9308-1484a5b727a9)

## 🔗Swagger Hub Link:
https://app.swaggerhub.com/apis/DANAAKESH_1/InventoryManagmentSystemRestAPI/1.0.0
