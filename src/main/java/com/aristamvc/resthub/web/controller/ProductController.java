package com.aristamvc.resthub.web.controller;

import com.aristamvc.resthub.web.model.ProductDTO;
import com.aristamvc.resthub.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/product")
@RestController             // Extends Controller Annotation
public class ProductController {
    // DATA MEMBERS
    private final ProductService productService;

    // CONSTRUCTOR
    public ProductController(ProductService productService){ this.productService = productService; }

    // METHOD MEMBERS
    @GetMapping({"/{productID}"})
    public ResponseEntity<ProductDTO> getProduct(@PathVariable UUID productID){
        return new ResponseEntity<>(productService.getProductById(productID).builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity handlePost(@RequestBody ProductDTO productDTO){
        // Create one to save
        ProductDTO saved = productService.saveNewProduct(productDTO);
        // Get resource JSON
        HttpHeaders headers = new HttpHeaders();
        // TODO add hostname to URL
        headers.add("Location", "/api/v1/product" + saved.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{productID}"})
    public ResponseEntity handleUpdate(@PathVariable UUID productID, @RequestBody ProductDTO productDTO){
        productService.updateProduct(productID, productDTO);
        // HTTP 204 (Successful NO CONTENT IN THE BODY)
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{productID}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable UUID productID){
        productService.deleteById(productID);
    }
}
