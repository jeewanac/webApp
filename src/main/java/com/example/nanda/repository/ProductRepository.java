package com.example.nanda.repository;

import com.example.nanda.entity.CategoryEntity;
import com.example.nanda.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p WHERE p.categoryEntity=:categoryEntity")
    List<ProductEntity> findByCategory(@Param("categoryEntity")CategoryEntity categoryEntity);
}
