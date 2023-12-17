package com.example.nanda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.nanda.dto.OrderDTO;
import com.example.nanda.entity.OrderEntity;

@Service
public interface OrderService {
    List<OrderEntity> getAllOrders();
    OrderEntity createOrder(OrderDTO orderDTO);
    OrderEntity findOrderById(Long id);
}
