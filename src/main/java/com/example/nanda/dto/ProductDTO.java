package com.example.nanda.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Double price;
    private Integer qty;
    private Long categoryId;
}
