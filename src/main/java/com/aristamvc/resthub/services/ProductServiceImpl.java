package com.aristamvc.resthub.services;

import com.aristamvc.resthub.web.model.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDTO getProductById(UUID productId) {
        return ProductDTO
                .builder()
                .id(UUID.randomUUID())
                .name("ART1")
                .category("Furniture")
                .build();
    }

    @Override
    public ProductDTO saveNewProduct(ProductDTO productDTO) {
        return ProductDTO
                .builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateProduct(UUID productID, ProductDTO productDTO) {
        // TODO IMPLEMENTATION
    }

    @Override
    public void deleteById(UUID productID) {
        log.debug("Deleting product");
    }
}
