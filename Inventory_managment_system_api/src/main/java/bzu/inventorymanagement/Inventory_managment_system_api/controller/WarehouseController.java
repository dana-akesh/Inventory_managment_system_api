package bzu.inventorymanagement.Inventory_managment_system_api.controller;

import bzu.inventorymanagement.Inventory_managment_system_api.dto.WarehouseDTO;
import bzu.inventorymanagement.Inventory_managment_system_api.service.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {
    private final Logger log = LoggerFactory.getLogger(WarehouseController.class);

    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/{warehouseid}")
    public ResponseEntity<WarehouseDTO> getWarehouseByid(
            @PathVariable(name = "warehouseid") long id) {
        return ResponseEntity.ok(warehouseService.getWarehouseById(id));
    }

    @PutMapping
    public ResponseEntity<WarehouseDTO> rewriteWarehouse(@RequestBody WarehouseDTO warehouseDTO){
        WarehouseDTO rewritedWarehouse = warehouseService.rewriteWarehouse(warehouseDTO);
        return new ResponseEntity<>(rewritedWarehouse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WarehouseDTO> addWarehouse(@RequestBody WarehouseDTO warehouseDTO){
        WarehouseDTO addedWarehouse = warehouseService.createWarehouse(warehouseDTO);
        return new ResponseEntity<>(addedWarehouse, HttpStatus.CREATED);
    }

    @PatchMapping("/{warehouseid}")
    public ResponseEntity<WarehouseDTO> updateWarehouse(@RequestBody WarehouseDTO warehouseDTO, @PathVariable(name = "warehouseid") long id){
        WarehouseDTO updatedWarehouse = warehouseService.updateWarehouse(warehouseDTO, id);
        return new ResponseEntity<>(updatedWarehouse, HttpStatus.OK);
    }

    @DeleteMapping("/{warehouseid}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable(name = "warehouseid") long id) {
        warehouseService.deleteWarehouse(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
