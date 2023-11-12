package com.example.inventorymanagement.dto;

import java.util.List;

import com.example.inventorymanagement.model.Category;
import com.example.inventorymanagement.model.Supplier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    
     private String name;
    
    private double price;

    private int quantity;

    private String description;

    private List<Category> category;

    private Supplier supplier;
}
