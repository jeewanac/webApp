package com.example.nanda.controller;

import com.example.nanda.entity.CategoryEntity;
import com.example.nanda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryEntity>> getAllCategories(){
        List<CategoryEntity> categoryEntities = categoryService.getAllCategories();

        if(categoryEntities!=null){
            return ResponseEntity.status(200).body(categoryEntities);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryEntity> findByCategory(@PathVariable Long id){
        CategoryEntity entity = categoryService.getCategoryById(id);

        if(entity!=null){
            return ResponseEntity.status(200).body(entity);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/categories")
    public CategoryEntity createCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryService.createCategory(categoryEntity);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryEntity> findByCategory(@PathVariable Long id, @RequestBody CategoryEntity categoryEntity){
        CategoryEntity category = categoryService.updateCategory(id,categoryEntity);

        if(category!=null){
            return ResponseEntity.status(200).body(category);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
