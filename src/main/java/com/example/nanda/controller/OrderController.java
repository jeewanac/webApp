package com.example.nanda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nanda.dto.OrderDTO;
import com.example.nanda.entity.OrderEntity;
import com.example.nanda.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderEntity>> getAllOrders(){
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderEntity> findOrderById(@RequestBody Long id){
        OrderEntity orderEntity = orderService.findOrderById(id);

        if(orderEntity!=null){
            return ResponseEntity.status(200).body(orderEntity);
        }else{
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderEntity> createOrders(@PathVariable OrderDTO dto){
        return ResponseEntity.status(200).body(orderService.createOrder(dto));
    }
}
