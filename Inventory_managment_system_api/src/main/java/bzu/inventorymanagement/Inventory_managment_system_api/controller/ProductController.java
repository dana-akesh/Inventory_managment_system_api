package bzu.inventorymanagement.Inventory_managment_system_api.controller;

import bzu.inventorymanagement.Inventory_managment_system_api.dto.ProductDTO;
import bzu.inventorymanagement.Inventory_managment_system_api.exception.BadRequestException;
import bzu.inventorymanagement.Inventory_managment_system_api.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productid}")
    public ResponseEntity<ProductDTO> getProductByid(
            @PathVariable(name = "productid") long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PutMapping
    public ResponseEntity<ProductDTO> rewriteProduct(@RequestBody ProductDTO productDTO){
        ProductDTO rewritedProduct = productService.rewriteProduct(productDTO);
        return new ResponseEntity<>(rewritedProduct, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO){
        if (productDTO.getProductid() == null){
            log.error("Cannot have an ID {}", productDTO);
            throw new BadRequestException(ProductController.class.getSimpleName(),"Id");
        }
        ProductDTO addedProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @PatchMapping("/{productid}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable(name = "productid") long id){
        ProductDTO updatedProduct = productService.updateProduct(productDTO, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{productid}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "productid") long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
