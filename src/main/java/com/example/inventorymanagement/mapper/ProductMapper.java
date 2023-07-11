package com.example.inventorymanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.inventorymanagement.dto.ProductDTO;
import com.example.inventorymanagement.model.Product;

@Mapper
public interface ProductMapper {
    
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO (Product product);
    
    Product productDTOToProduct (ProductDTO productDTO);
    
    List<ProductDTO> listProductToListProductDTO (List<Product> product);
}
