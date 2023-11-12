package com.example.inventorymanagement.controller;

import java.util.List;
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

import com.example.inventorymanagement.dto.CategoryDTO;
import com.example.inventorymanagement.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/v1/categories", produces = { "application/json" })
@AllArgsConstructor
public class CategoryController {

    public final CategoryService categoryService;

    @Operation(summary = "Create Category", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category created")
    })
    @PostMapping
    public ResponseEntity<Object> saveCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.saveCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category created.");
    }

    @Operation(summary = "Find Category by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category found"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdCategory(
            @PathVariable(value = "id") @Parameter(name = "id", description = "Category id", example = "85419402-8372-4008-b378-04c79a61b407") UUID id) {
        CategoryDTO categoryDTO = categoryService.findByIdCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDTO);
    }

    @Operation(summary = "Find all Categories", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Categories found")
    })
    @GetMapping
    public ResponseEntity<Object> findAllCategories() {
        List<CategoryDTO> categoriesDTO = categoryService.findAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categoriesDTO);
    }

    @Operation(summary = "Delete Category by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category deleted"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdCategories(
            @PathVariable(value = "id") @Parameter(name = "id", description = "Category id", example = "85419402-8372-4008-b378-04c79a61b407") UUID id) {
        categoryService.deleteByIdCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully.");
    }
}
