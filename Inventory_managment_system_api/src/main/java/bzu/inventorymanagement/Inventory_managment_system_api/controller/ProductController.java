package bzu.inventorymanagement.Inventory_managment_system_api.controller;

import bzu.inventorymanagement.Inventory_managment_system_api.dto.ProductDTO;
import bzu.inventorymanagement.Inventory_managment_system_api.service.ProductService;
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
        ProductDTO rewritedCat = productService.rewriteProduct(productDTO);
        return new ResponseEntity<>(rewritedCat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO){
        ProductDTO addedCat = productService.createProduct(productDTO);
        return new ResponseEntity<>(addedCat, HttpStatus.OK);
    }

    @PatchMapping("/{productid}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable(name = "productid") long id){
        ProductDTO updatedCat = productService.updateProduct(productDTO, id);
        return new ResponseEntity<>(updatedCat, HttpStatus.OK);
    }

    @DeleteMapping("/{productid}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "productid") long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
