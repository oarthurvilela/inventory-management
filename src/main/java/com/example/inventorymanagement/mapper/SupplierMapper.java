package com.example.inventorymanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.inventorymanagement.dto.SupplierDTO;
import com.example.inventorymanagement.model.Supplier;

@Mapper
public interface SupplierMapper {
    
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierDTO supplierToSupplierDTO (Supplier supplier);
    
    Supplier supplierDTOToSupplier (SupplierDTO supplierDTO);
    
    List<SupplierDTO> listSupplierToListSupplierDTO (List<Supplier> supplier);
}
