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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/v1/suppliers")
@AllArgsConstructor
public class SupplierController {
    
    public final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Object> saveSupplier(@Valid @RequestBody SupplierDTO supplierDTO) {
        supplierService.saveSupplier(supplierDTO);        
        return ResponseEntity.status(HttpStatus.CREATED).body("Supplier created.");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdSupplier(@PathVariable(value = "id") UUID id) {
        SupplierDTO supplierDTO = supplierService.findByIdSupplier(id);
        return ResponseEntity.status(HttpStatus.OK).body(supplierDTO);
    }

    @GetMapping
    public ResponseEntity<Object> findAllSuppliers() {
        List<SupplierDTO> suppliersDTO = supplierService.findAllSuppliers();
        return ResponseEntity.status(HttpStatus.OK).body(suppliersDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdSupplier(@PathVariable(value = "id") UUID id) {        
        supplierService.deleteByIdSupplier(id);
        return ResponseEntity.status(HttpStatus.OK).body("Supplier deleted successfully.");
    }
}
