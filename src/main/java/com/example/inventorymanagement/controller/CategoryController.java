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

import com.example.inventorymanagement.model.Category;
import com.example.inventorymanagement.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/v1/categories")
@AllArgsConstructor
public class CategoryController {
    
    public final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Object> saveCategory(@Valid @RequestBody Category category) {
        categoryService.saveCategory(category);        
        return ResponseEntity.status(HttpStatus.CREATED).body("Category created.");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdCategory(@PathVariable(value = "id") UUID id) {
        Optional<Category> category = categoryService.findByIdCategory(id);

        if(!category.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(category.get());

    }

    @GetMapping
    public ResponseEntity<Object> findAllAddresses() {
        List<Category> categories = categoryService.findAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdAddress(@PathVariable(value = "id") UUID id) {
        Optional<Category> category = categoryService.findByIdCategory(id);

        if(!category.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found.");
        }
        categoryService.deleteByIdCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully.");
    }
}
