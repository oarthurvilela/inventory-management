package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.inventorymanagement.dto.ProductDTO;
import com.example.inventorymanagement.exception.ResourceNotFoundException;
import com.example.inventorymanagement.mapper.ProductMapper;
import com.example.inventorymanagement.model.Product;
import com.example.inventorymanagement.repository.ProductRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void saveProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(productDTO);
        productRepository.save(product);
    }

    public ProductDTO findByIdProduct(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id [%s] not found".formatted(id)));
        
        ProductDTO productDTO = ProductMapper.INSTANCE.productToProductDTO(product);

        return productDTO;
    }

    public List<ProductDTO> findAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = ProductMapper.INSTANCE.listProductToListProductDTO(products);

        return productsDTO;
    }

    @Transactional
    public void deleteByIdProduct(UUID id) {
        checkIfProductExistsOrThrow(id);
        productRepository.deleteById(id);
    }

    private void checkIfProductExistsOrThrow(UUID id) {
        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent()) {
            throw new ResourceNotFoundException(
                    "Product with id [%s] not found".formatted(id));
        }
    }
}
