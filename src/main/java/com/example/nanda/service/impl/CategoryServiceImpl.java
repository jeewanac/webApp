package com.example.nanda.service.impl;

import com.example.nanda.entity.CategoryEntity;
import com.example.nanda.repository.CategoryRepository;
import com.example.nanda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity) {
         CategoryEntity exist = categoryRepository.findById(id).orElse(categoryEntity);

         if(exist!=null){
             exist.setName(categoryEntity.getName());
             return categoryRepository.save(exist);
         }else {
             return null;
         }
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
