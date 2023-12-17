package com.example.nanda.service.impl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nanda.dto.OrderDTO;
import com.example.nanda.entity.OrderEntity;
import com.example.nanda.entity.ProductEntity;
import com.example.nanda.repository.OrderRepository;
import com.example.nanda.repository.ProductRepository;
import com.example.nanda.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity createOrder(OrderDTO orderDTO) {
        List<Long> productIds = orderDTO.getProducts();

        Set<ProductEntity> products = new HashSet<>();
        Double total = 0.0;

        for (Long productId : productIds) {
            ProductEntity product = productRepository.findById(productId).orElse(null);

            if(product!=null){
                products.add(product);
                total = total + product.getPrice();
            }
        }

        Double tax = (total/100)*10;
        LocalDateTime orderDate = LocalDateTime.now();

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setTotal(total);
        orderEntity.setTax(tax);
        orderEntity.setOrderDate(orderDate);
        orderEntity.setProducts(products);

        return orderRepository.save(orderEntity);
    }

    @Override
    public OrderEntity findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    
}
