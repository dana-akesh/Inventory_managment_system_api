# ⭐ Inventory Managment System Rest API ⭐
The Inventory Management System API provides endpoints for managing inventory-related operations within a business or organization.With the use of _OpenAi 3.1.0_ it allows the user to add, update, and delete the core reasources which are the product, category, warehouse, and shipment. The project is tested via postman.
## 🔖Table Of Contents:
- [Core Resources](#core-resources)
- [ER Diagram](#er-diagram)
- [Design and Documentation Tables for the Core Resources](#design-and-documentation-tables-for-the-core-resources)
- [Swagger Hub Link](#swagger-hub-link)
- Postman file (included within the repository files) 
## 💡Core Resources:
<ol>
  <li>
    <b>Product: </b> 
    The items that are managed by the inventory system, and it has an ID, description, name, price, and quantity.
  </li>
  <li>
    <b>Category:</b>
    The groups of a particular products that have similar attributes, and to organize the inventory.
  </li>
  <li>
    <b>Warehouse: </b>
    The place where the items are stored, and it has an address, capacity, and name.
  </li>
  <li>
    <b>Shipment: </b>
    To follow up with the movement of products between locations with details on quantity, status, and tracking number.
  </li>
</ol>

## 💠ER Diagram:
![ER_Diagram drawio](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/cfc080e9-bf7e-41d0-9d13-de69df9503b0)

## Prerequisites:
  - IntelliJ IDEA
  - Postman
  - Maven
  - Java Development Kit (JDK) 19 or higher
  - MySQL Workbench
    
## Clone the Repository:
```bash
git clone https://github.com/dana-akesh/Inventory_managment_system_api
cd  Inventory_managment_system_api
```
ℹ️ note: the application should be running on Port 8080 -> http://localhost:8080. 

## 🪄Design and Documentation Tables for the Core Resources:
### /product
![image](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/203cbd92-5581-4071-9326-e4dc44d511e7)

### /category
![image](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/14d8453f-cf0a-494e-98bb-219ae6bce006)

### /warehouse
![image](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/b827556c-6508-4232-a86a-886cdba733ba)

### /shipment
![image](https://github.com/dana-akesh/Inventory_managment_system_api/assets/86303193/6f3823f2-d01e-4223-bc27-5eaf2280db56)

## 🔗Swagger Hub Link:
https://app.swaggerhub.com/apis/DANAAKESH_1/InventoryManagmentSystemRestAPI/1.0.0
