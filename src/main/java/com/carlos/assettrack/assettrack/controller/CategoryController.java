package com.carlos.assettrack.assettrack.controller;

import com.carlos.assettrack.assettrack.model.Category;
import com.carlos.assettrack.assettrack.service.CategoryService;
import com.carlos.assettrack.assettrack.service.ICategoryService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("asset-app/categories")
@CrossOrigin(value = "http://localhost:3000")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryService categoryService;

    // Obtener todas las categorías: GET http://localhost:8080/asset-app/categories
    @GetMapping
    public List<Category> getCategories(){
        logger.info("Listing all categories");
        return categoryService.getAllCategories();
    }

    // Guardar una categoría: POST http://localhost:8080/asset-app/categories
    @PostMapping
    public Category addCategory(@Valid @RequestBody Category category){
        logger.info("Adding category {}", category);
        return categoryService.saveCategory(category);
    }

    // Obtener una categoría por Id: GET http://localhost:8080/asset-app/categories/{id}
    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long id){
        logger.info("Getting category with id {}", id);
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(category);
    }

    // Eliminar una categoría por Id: DELETE http://localhost:8080/asset-app/categories/{id}
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(value = "id") Long id){
        logger.info("Deleting category with id {}", id);
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }

}
