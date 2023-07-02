package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.inventorymanagement.model.Product;
import com.example.inventorymanagement.repository.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> findByIdProduct(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    public List<Product> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Transactional
    public void deleteByIdProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
