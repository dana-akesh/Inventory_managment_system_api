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
        Shipment shipment = shipmentRepository.findById(shipmentDTO.getShipmentid()).orElseThrow(() -> new ResourceNotFoundException("Shipment","id", shipmentDTO.getShipmentid()));

        shipment.setShipmentid(shipmentDTO.getShipmentid());
        shipment.setStatus(shipmentDTO.getStatus());
        shipment.setWarehouse(shipmentDTO.getWarehouses());
        shipment.setTracking_number(shipmentDTO.getTracking_number());
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

        shipment.setShipmentid(id);
        shipment.setStatus(shipmentDTO.getStatus());
        shipment.setWarehouse(shipmentDTO.getWarehouses());
        shipment.setTracking_number(shipmentDTO.getTracking_number());

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

        shipmentDTO.setShipmentid(shipment.getShipmentid());
        shipmentDTO.setStatus(shipment.getStatus());
        shipmentDTO.setProducts(shipment.getProduct());
        shipmentDTO.setWarehouses(shipment.getWarehouse());
        shipmentDTO.setTracking_number(shipment.getTracking_number());

        return shipmentDTO;
    }

    private Shipment mapToEntity(ShipmentDTO shipmentDTO){
        Shipment shipment = new Shipment();

        shipment.setShipmentid(shipmentDTO.getShipmentid());
        shipment.setStatus(shipmentDTO.getStatus());
        shipment.setProduct(shipmentDTO.getProducts());
        shipment.setWarehouse(shipmentDTO.getWarehouses());
        shipment.setTracking_number(shipmentDTO.getTracking_number());

        return shipment;
    }
}
