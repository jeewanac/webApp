package com.example.nanda.service;

import com.example.nanda.dto.ProductDTO;
import com.example.nanda.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductEntity> getAllProducts();
    ProductEntity getProductById(Long id);
    ProductEntity createProduct(ProductDTO dto);
    ProductEntity updateProduct(Long id, ProductDTO dto);
    void deleteById(Long id);

    List<ProductEntity> findByCategory(Long id);
}
