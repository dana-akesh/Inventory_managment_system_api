package bzu.inventorymanagement.Inventory_managment_system_api.controller;


import bzu.inventorymanagement.Inventory_managment_system_api.dto.ShipmentDTO;
import bzu.inventorymanagement.Inventory_managment_system_api.service.ShipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shipment")
public class ShipmentController {
    private final Logger log = LoggerFactory.getLogger(ShipmentController.class);

    private ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping("/{shipmentid}")
    public ResponseEntity<ShipmentDTO> getShipmentByid(
            @PathVariable(name = "shipmentid") long id) {
        return ResponseEntity.ok(shipmentService.getShipmentById(id));
    }

    @PutMapping
    public ResponseEntity<ShipmentDTO> rewriteShipment(@RequestBody ShipmentDTO shipmentDTO){
        ShipmentDTO rewritedShipment = shipmentService.rewriteShipment(shipmentDTO);
        return new ResponseEntity<>(rewritedShipment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShipmentDTO> addShipment(@RequestBody ShipmentDTO shipmentDTO){
        ShipmentDTO addedShipment = shipmentService.createShipment(shipmentDTO);
        return new ResponseEntity<>(addedShipment, HttpStatus.CREATED);
    }

    @PatchMapping("/{shipmentid}")
    public ResponseEntity<ShipmentDTO> updateShipment(@RequestBody ShipmentDTO shipmentDTO, @PathVariable(name = "shipmentid") long id){
        ShipmentDTO updatedShipment = shipmentService.updateShipment(shipmentDTO, id);
        return new ResponseEntity<>(updatedShipment, HttpStatus.OK);
    }

    @DeleteMapping("/{shipmentid}")
    public ResponseEntity<String> deleteShipment(@PathVariable(name = "shipmentid") long id) {
        shipmentService.deleteShipment(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
