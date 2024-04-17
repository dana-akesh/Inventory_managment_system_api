package bzu.inventorymanagement.Inventory_managment_system_api.controller;

import bzu.inventorymanagement.Inventory_managment_system_api.dto.CategoryDTO;
import bzu.inventorymanagement.Inventory_managment_system_api.service.CategoryService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final Logger log = LoggerFactory.getLogger(CategoryController.class);

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryid}")
    public ResponseEntity<CategoryDTO> getCategoryById(
            @PathVariable(name = "categoryid") String id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> rewriteCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO rewritedCat = categoryService.rewriteCategory(categoryDTO);
        return new ResponseEntity<>(rewritedCat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO addedCat = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(addedCat, HttpStatus.OK);
    }

    @PatchMapping("/{categoryid}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable(name = "categoryid") String id){
        CategoryDTO updatedCat = categoryService.updateCategoryByID(categoryDTO, id);
        return new ResponseEntity<>(updatedCat, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryid}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "categoryid") String id) {
        categoryService.deleteCategoryByID(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
