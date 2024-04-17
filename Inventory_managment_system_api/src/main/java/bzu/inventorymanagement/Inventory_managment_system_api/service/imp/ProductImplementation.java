package bzu.inventorymanagement.Inventory_managment_system_api.service.imp;

import bzu.inventorymanagement.Inventory_managment_system_api.dto.ProductDTO;
import bzu.inventorymanagement.Inventory_managment_system_api.entity.Product;
import bzu.inventorymanagement.Inventory_managment_system_api.exception.ResourceNotFoundException;
import bzu.inventorymanagement.Inventory_managment_system_api.repository.ProductRepository;
import bzu.inventorymanagement.Inventory_managment_system_api.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductImplementation implements ProductService {
    private ProductRepository productRepository;

    public ProductImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO rewriteProduct(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getProductID()).orElseThrow(() -> new ResourceNotFoundException("Product","id", productDTO.getProductID()));

        product.setCategory(productDTO.getCategory());
        product.setProductID(productDTO.getProductID());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        productRepository.save(product);

        return productDTO;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        // convert DTO to entity
        Product product = mapToEntity(productDTO);
        Product savedProduct = productRepository.save(product);

        // convert entity to DTO
        ProductDTO productResponse = mapToDTO(savedProduct);
        return productResponse;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","id", id));

        product.setCategory(productDTO.getCategory());
        product.setProductID(product.getProductID());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        productRepository.save(product);
        Product savedProduct = productRepository.save(product);

        return mapToDTO(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","id", id));
        return mapToDTO(product);
    }

    @Override
    public void deleteProduct(Long productId){
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product","id", productId));
        productRepository.delete(product);
    }

    private ProductDTO mapToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setCategory(product.getCategory());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());

        return productDTO;
    }

    private Product mapToEntity(ProductDTO productDTO){
        Product product = new Product();

        product.setName(productDTO.getName());
        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        return product;
    }
}
