package com.example.nanda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nanda.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{
    
}
