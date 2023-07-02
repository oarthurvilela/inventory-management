package com.example.inventorymanagement.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanagement.model.Product;
import com.example.inventorymanagement.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/v1/products")
@AllArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Object> saveProduct(@Valid @RequestBody Product product) {
        productService.saveProduct(product);        
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created.");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdProduct(@PathVariable(value = "id") UUID id) {
        Optional<Product> product = productService.findByIdProduct(id);

        if(!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product.get());

    }

    @GetMapping
    public ResponseEntity<Object> findAllProducts() {
        List<Product> product = productService.findAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(product);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdProduct(@PathVariable(value = "id") UUID id) {
        Optional<Product> product = productService.findByIdProduct(id);

        if(!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        productService.deleteByIdProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

}
