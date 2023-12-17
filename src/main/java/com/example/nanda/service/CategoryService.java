package com.example.nanda.service;

import com.example.nanda.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryEntity> getAllCategories();
    CategoryEntity getCategoryById(Long id);
    CategoryEntity createCategory(CategoryEntity categoryEntity);
    CategoryEntity updateCategory(Long id , CategoryEntity categoryEntity);
    void deleteCategory(Long id);
}
