package bzu.inventorymanagement.Inventory_managment_system_api.service.imp;

import bzu.inventorymanagement.Inventory_managment_system_api.dto.ShipmentDTO;
import bzu.inventorymanagement.Inventory_managment_system_api.entity.Shipment;
import bzu.inventorymanagement.Inventory_managment_system_api.exception.ResourceNotFoundException;
import bzu.inventorymanagement.Inventory_managment_system_api.repository.ShipmentRepository;
import bzu.inventorymanagement.Inventory_managment_system_api.service.ShipmentService;
import org.springframework.stereotype.Service;

@Service
public class ShipmentImplementation implements ShipmentService {
    private ShipmentRepository shipmentRepository;

    public ShipmentImplementation(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public ShipmentDTO rewriteShipment(ShipmentDTO shipmentDTO) {
        Shipment shipment = shipmentRepository.findById(shipmentDTO.getShipmentID()).orElseThrow(() -> new ResourceNotFoundException("Shipment","id", shipmentDTO.getShipmentID()));

        shipment.setShipmentID(shipmentDTO.getShipmentID());
        shipment.setStatus(shipmentDTO.getStatus());
        shipment.setWarehouse(shipmentDTO.getWarehouses());
        shipment.setTrackingNumber(shipmentDTO.getTrackingNumber());
        shipment.setProduct(shipmentDTO.getProducts());

        shipmentRepository.save(shipment);

        return shipmentDTO;
    }

    @Override
    public ShipmentDTO createShipment(ShipmentDTO shipmentDTO) {
        // convert DTO to entity
        Shipment shipment = mapToEntity(shipmentDTO);
        Shipment savedShipment = shipmentRepository.save(shipment);

        // convert entity to DTO
        ShipmentDTO shipmentResponse = mapToDTO(savedShipment);
        return shipmentResponse;
    }

    @Override
    public ShipmentDTO updateShipment(ShipmentDTO shipmentDTO, Long id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shipment","id", id));

        shipment.setShipmentID(id);
        shipment.setStatus(shipmentDTO.getStatus());
        shipment.setWarehouse(shipmentDTO.getWarehouses());
        shipment.setTrackingNumber(shipmentDTO.getTrackingNumber());

        shipmentRepository.save(shipment);

        Shipment savedShipment = shipmentRepository.save(shipment);
        return mapToDTO(savedShipment);
    }

    @Override
    public ShipmentDTO getShipmentById(Long id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shipment","id", id));
        return mapToDTO(shipment);
    }

    @Override
    public void deleteShipment(Long id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shipment","id", id));
        shipmentRepository.delete(shipment);
    }

    private ShipmentDTO mapToDTO(Shipment shipment){
        ShipmentDTO shipmentDTO = new ShipmentDTO();

        shipmentDTO.setShipmentID(shipment.getShipmentID());
        shipmentDTO.setStatus(shipment.getStatus());
        shipmentDTO.setProducts(shipment.getProduct());
        shipmentDTO.setWarehouses(shipment.getWarehouse());
        shipmentDTO.setTrackingNumber(shipment.getTrackingNumber());

        return shipmentDTO;
    }

    private Shipment mapToEntity(ShipmentDTO shipmentDTO){
        Shipment shipment = new Shipment();

        shipment.setShipmentID(shipmentDTO.getShipmentID());
        shipment.setStatus(shipmentDTO.getStatus());
        shipment.setProduct(shipmentDTO.getProducts());
        shipment.setWarehouse(shipmentDTO.getWarehouses());
        shipment.setTrackingNumber(shipmentDTO.getTrackingNumber());

        return shipment;
    }
}
