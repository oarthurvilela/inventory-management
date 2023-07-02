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

import com.example.inventorymanagement.model.Supplier;
import com.example.inventorymanagement.service.SupplierService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/v1/suppliers")
@AllArgsConstructor
public class SupplierController {
    
    public final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Object> saveSupplier(@Valid @RequestBody Supplier supplier) {
        supplierService.saveSupplier(supplier);        
        return ResponseEntity.status(HttpStatus.CREATED).body("Supplier created.");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdSupplier(@PathVariable(value = "id") UUID id) {
        Optional<Supplier> supplier = supplierService.findByIdSupplier(id);

        if(!supplier.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(supplier.get());

    }

    @GetMapping
    public ResponseEntity<Object> findAllSuppliers() {
        List<Supplier> suppliers = supplierService.findAllSuppliers();
        return ResponseEntity.status(HttpStatus.OK).body(suppliers);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdSupplier(@PathVariable(value = "id") UUID id) {
        Optional<Supplier> supplier = supplierService.findByIdSupplier(id);

        if(!supplier.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier not found.");
        }
        supplierService.deleteByIdSupplier(id);
        return ResponseEntity.status(HttpStatus.OK).body("Supplier deleted successfully.");
    }
}
