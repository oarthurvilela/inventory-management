package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.inventorymanagement.model.Category;
import com.example.inventorymanagement.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public Optional<Category> findByIdCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category;
    }

    public List<Category> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @Transactional
    public void deleteByIdCategory(UUID id) {
        categoryRepository.deleteById(id);
    }

}
