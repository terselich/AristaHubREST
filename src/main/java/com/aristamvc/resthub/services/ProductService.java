package com.aristamvc.resthub.services;

import com.aristamvc.resthub.web.model.ProductDTO;

import java.util.UUID;

public interface ProductService {
    ProductDTO getProductById(UUID productId);

    ProductDTO saveNewProduct(ProductDTO productDTO);

    void updateProduct(UUID productID, ProductDTO productDTO);

    void deleteById(UUID productID);
}
