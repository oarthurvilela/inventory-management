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

import com.example.inventorymanagement.dto.ProductDTO;
import com.example.inventorymanagement.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/v1/products", produces = { "application/json" })
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Create Product", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product created")
    })
    @PostMapping
    public ResponseEntity<Object> saveProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.saveProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created.");
    }

    @Operation(summary = "Find Product by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdProduct(
            @PathVariable(value = "id") @Parameter(name = "id", description = "Product id", example = "85419402-8372-4008-b378-04c79a61b407") UUID id) {
        ProductDTO productDTO = productService.findByIdProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    @Operation(summary = "Find all Products", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Products found")
    })
    @GetMapping
    public ResponseEntity<Object> findAllProducts() {
        List<ProductDTO> productsDTO = productService.findAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productsDTO);
    }

    @Operation(summary = "Delete Product by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdProduct(
            @PathVariable(value = "id") @Parameter(name = "id", description = "Product id", example = "85419402-8372-4008-b378-04c79a61b407") UUID id) {
        productService.deleteByIdProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }
}
