package com.example.inventorymanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.inventorymanagement.dto.CategoryDTO;
import com.example.inventorymanagement.model.Category;

@Mapper
public interface CategoryMapper {
    
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO (Category category);
    
    Category categoryDTOTocategory (CategoryDTO categoryDTO);

    List<CategoryDTO> listCategoryToListCategoryDTO (List<Category> categories);
}
