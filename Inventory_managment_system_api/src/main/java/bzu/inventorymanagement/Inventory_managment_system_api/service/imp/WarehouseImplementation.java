package bzu.inventorymanagement.Inventory_managment_system_api.service.imp;

import bzu.inventorymanagement.Inventory_managment_system_api.dto.WarehouseDTO;
import bzu.inventorymanagement.Inventory_managment_system_api.entity.Warehouse;
import bzu.inventorymanagement.Inventory_managment_system_api.exception.ResourceNotFoundException;
import bzu.inventorymanagement.Inventory_managment_system_api.repository.WarehouseRepository;
import bzu.inventorymanagement.Inventory_managment_system_api.service.WarehouseService;
import org.springframework.stereotype.Service;

@Service
public class WarehouseImplementation implements WarehouseService {
    private WarehouseRepository warehouseRepository;

    public WarehouseImplementation(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public WarehouseDTO rewriteWarehouse(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = warehouseRepository.findById(warehouseDTO.getWarehouseid()).orElseThrow(() -> new ResourceNotFoundException("Warehouse","id", warehouseDTO.getWarehouseid()));

        warehouse.setWarehouseid(warehouseDTO.getWarehouseid());
        warehouse.setCapacity(warehouseDTO.getCapacity());
        warehouse.setLocation(warehouseDTO.getLocation());
        warehouse.setName(warehouseDTO.getName());
        warehouse.setShipment(warehouseDTO.getShipments());
        warehouse.setProduct(warehouseDTO.getProducts());

        warehouseRepository.save(warehouse);

        return warehouseDTO;
    }

    @Override
    public WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO) {
        // convert DTO to entity
        Warehouse warehouse = mapToEntity(warehouseDTO);
        Warehouse savedWarehouse = warehouseRepository.save(warehouse);

        // convert entity to DTO
        WarehouseDTO warehouseResponse = mapToDTO(savedWarehouse);
        return warehouseResponse;
    }

    @Override
    public WarehouseDTO updateWarehouse(WarehouseDTO warehouseDTO, Long id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warehouse","id", id));

        warehouse.setProduct(warehouseDTO.getProducts());
        warehouse.setCapacity(warehouseDTO.getCapacity());
        warehouse.setLocation(warehouseDTO.getLocation());
        warehouse.setName(warehouseDTO.getName());
        warehouse.setShipment(warehouseDTO.getShipments());
        warehouse.setWarehouseid(id);

        warehouseRepository.save(warehouse);
        Warehouse savedWarehouse = warehouseRepository.save(warehouse);

        return mapToDTO(savedWarehouse);
    }

    @Override
    public WarehouseDTO getWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warehouse","id", id));
        return mapToDTO(warehouse);
    }

    @Override
    public void deleteWarehouse(Long warehouseId) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId).orElseThrow(() -> new ResourceNotFoundException("Warehouse","id", warehouseId));
        warehouseRepository.delete(warehouse);
    }

    private WarehouseDTO mapToDTO(Warehouse warehouse){
        WarehouseDTO warehouseDTO = new WarehouseDTO();

        warehouseDTO.setWarehouseid(warehouse.getWarehouseid());
        warehouseDTO.setLocation(warehouse.getLocation());
        warehouseDTO.setName(warehouse.getName());
        warehouseDTO.setCapacity(warehouse.getCapacity());
        warehouseDTO.setShipments(warehouse.getShipment());
        warehouseDTO.setProducts(warehouse.getProduct());

        return warehouseDTO;
    }

    private Warehouse mapToEntity(WarehouseDTO warehouseDTO){
        Warehouse warehouse = new Warehouse();

        warehouse.setWarehouseid(warehouseDTO.getWarehouseid());
        warehouse.setLocation(warehouseDTO.getLocation());
        warehouse.setName(warehouseDTO.getName());
        warehouse.setCapacity(warehouseDTO.getCapacity());
        warehouse.setShipment(warehouseDTO.getShipments());
        warehouse.setProduct(warehouseDTO.getProducts());

        return warehouse;
    }
}
