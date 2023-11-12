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

import com.example.inventorymanagement.dto.SupplierDTO;
import com.example.inventorymanagement.service.SupplierService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/v1/suppliers", produces = { "application/json" })
@AllArgsConstructor
public class SupplierController {

    public final SupplierService supplierService;

    @Operation(summary = "Create Supplier", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Supplier created")
    })
    @PostMapping
    public ResponseEntity<Object> saveSupplier(@Valid @RequestBody SupplierDTO supplierDTO) {
        supplierService.saveSupplier(supplierDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Supplier created.");
    }

    @Operation(summary = "Find Supplier by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Supplier found"),
            @ApiResponse(responseCode = "404", description = "Supplier not found")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdSupplier(
            @PathVariable(value = "id") @Parameter(name = "id", description = "Supplier id", example = "85419402-8372-4008-b378-04c79a61b407") UUID id) {
        SupplierDTO supplierDTO = supplierService.findByIdSupplier(id);
        return ResponseEntity.status(HttpStatus.OK).body(supplierDTO);
    }

    @Operation(summary = "Find all Suppliers", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Suppliers found")
    })
    @GetMapping
    public ResponseEntity<Object> findAllSuppliers() {
        List<SupplierDTO> suppliersDTO = supplierService.findAllSuppliers();
        return ResponseEntity.status(HttpStatus.OK).body(suppliersDTO);
    }

    @Operation(summary = "Delete Supplier by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Supplier deleted"),
            @ApiResponse(responseCode = "404", description = "Supplier not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdSupplier(
            @PathVariable(value = "id") @Parameter(name = "id", description = "Supplier id", example = "85419402-8372-4008-b378-04c79a61b407") UUID id) {
        supplierService.deleteByIdSupplier(id);
        return ResponseEntity.status(HttpStatus.OK).body("Supplier deleted successfully.");
    }
}
