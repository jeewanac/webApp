package com.example.nanda.service.impl;

import com.example.nanda.dto.ProductDTO;
import com.example.nanda.entity.CategoryEntity;
import com.example.nanda.entity.ProductEntity;
import com.example.nanda.repository.CategoryRepository;
import com.example.nanda.repository.ProductRepository;
import com.example.nanda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity createProduct(ProductDTO dto) {
        CategoryEntity categoryEntity = categoryRepository.findById(dto.getCategoryId()).orElse(null);

        if(categoryEntity!=null){
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(dto.getName());
            productEntity.setPrice(dto.getPrice());
            productEntity.setQty(dto.getQty());
            productEntity.setCategoryEntity(categoryEntity);

            return productRepository.save(productEntity);
        }else {
            return  null;
        }
    }

    @Override
    public ProductEntity updateProduct(Long id, ProductDTO dto) {
         ProductEntity exist = productRepository.findById(id).orElse(null);
         CategoryEntity categoryEntity = categoryRepository.findById(dto.getCategoryId()).orElse(null);

         if(exist!=null && categoryEntity!=null){
             exist.setName(dto.getName());
             exist.setPrice(dto.getPrice());
             exist.setQty(dto.getQty());
             exist.setCategoryEntity(categoryEntity);

             return productRepository.save(exist);
         }else {
             return null;
         }
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductEntity> findByCategory(Long id) {
         CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);

         if(categoryEntity!=null){
             return productRepository.findByCategory(categoryEntity);
         }else {
             return  null;
         }
    }
}
