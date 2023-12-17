package com.example.nanda.controller;

import com.example.nanda.dto.ProductDTO;
import com.example.nanda.entity.ProductEntity;
import com.example.nanda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        List<ProductEntity> productEntities = productService.getAllProducts();

        if(productEntities!=null){
            return ResponseEntity.status(200).body(productEntities);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id){
        ProductEntity productEntity = productService.getProductById(id);

        if(productEntity!=null){
            return  ResponseEntity.status(200).body(productEntity);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/products")
    public ProductEntity createProduct(@RequestBody ProductDTO dto){
        return productService.createProduct(dto);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductEntity> updateMapping(@PathVariable Long id, @RequestBody ProductDTO dto){
        ProductEntity productEntity = productService.updateProduct(id, dto);

        if(productEntity!=null){
            return ResponseEntity.status(200).body(productEntity);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

    /*@GetMapping("categories/{id}/products/")
    public ResponseEntity<List<ProductEntity>> findByCategory(@PathVariable Long id){
        List<ProductEntity> productEntities = productService.findByCategory(id);

        if(productEntities!=null){
            return  ResponseEntity.status(200).body(productEntities);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }*/

    @GetMapping("/categories/{id}/products")
    public List<ProductEntity> findByCategory(@PathVariable Long id){
        return productService.findByCategory(id);
    }
}
