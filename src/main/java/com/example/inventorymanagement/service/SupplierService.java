package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.inventorymanagement.model.Supplier;
import com.example.inventorymanagement.repository.SupplierRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SupplierService {
    
    private final SupplierRepository supplierRepository;

     @Transactional
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public Optional<Supplier> findByIdSupplier(UUID id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        return supplier;
    }

    public List<Supplier> findAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers;
    }

    @Transactional
    public void deleteByIdSupplier(UUID id) {
        supplierRepository.deleteById(id);
    }
}
