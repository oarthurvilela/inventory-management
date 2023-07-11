package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.inventorymanagement.dto.SupplierDTO;
import com.example.inventorymanagement.exception.ResourceNotFoundException;
import com.example.inventorymanagement.mapper.SupplierMapper;
import com.example.inventorymanagement.model.Supplier;
import com.example.inventorymanagement.repository.SupplierRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SupplierService {
    
    private final SupplierRepository supplierRepository;

     @Transactional
    public void saveSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = SupplierMapper.INSTANCE.supplierDTOToSupplier(supplierDTO);
        supplierRepository.save(supplier);
    }

    public SupplierDTO findByIdSupplier(UUID id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier with id [%s] not found".formatted(id)));
        
        SupplierDTO supplierDTO = SupplierMapper.INSTANCE.supplierToSupplierDTO(supplier);

        return supplierDTO;
    }

    public List<SupplierDTO> findAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierDTO> suppliersDTO = SupplierMapper.INSTANCE.listSupplierToListSupplierDTO(suppliers);

        return suppliersDTO;
    }

    @Transactional
    public void deleteByIdSupplier(UUID id) {
        checkIfSupplierExistsOrThrow(id);
        supplierRepository.deleteById(id);
    }

    private void checkIfSupplierExistsOrThrow(UUID id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);

        if (!supplier.isPresent()) {
            throw new ResourceNotFoundException(
                    "Supplier with id [%s] not found".formatted(id));
        }
    }
}
