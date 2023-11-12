package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.inventorymanagement.dto.CategoryDTO;
import com.example.inventorymanagement.exception.ResourceNotFoundException;
import com.example.inventorymanagement.mapper.CategoryMapper;
import com.example.inventorymanagement.model.Category;
import com.example.inventorymanagement.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public void saveCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.INSTANCE.categoryDTOTocategory(categoryDTO);
        categoryRepository.save(category);
    }

    public CategoryDTO findByIdCategory(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id [%s] not found".formatted(id)));

        CategoryDTO categoryDTO = CategoryMapper.INSTANCE.categoryToCategoryDTO(category);

        return categoryDTO;
    }

    public List<CategoryDTO> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoriesDTO = CategoryMapper.INSTANCE.listCategoryToListCategoryDTO(categories);

        return categoriesDTO;
    }

    @Transactional
    public void deleteByIdCategory(UUID id) {
        checkIfCategoryExistsOrThrow(id);
        categoryRepository.deleteById(id);
    }

    private void checkIfCategoryExistsOrThrow(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);

        if (!category.isPresent()) {
            throw new ResourceNotFoundException(
                    "Category with id [%s] not found".formatted(id));
        }
    }
}
