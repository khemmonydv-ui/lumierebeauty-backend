package com.flashsolution.lumierebeauty.controller;

import com.flashsolution.lumierebeauty.entity.Product;
import com.flashsolution.lumierebeauty.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        // Validation: price is required and cannot be negative
        if (product.getPrice() == null) {
            return ResponseEntity.badRequest().body("Price is required.");
        }
        if (product.getPrice() < 0) {
            return ResponseEntity.badRequest().body("Price cannot be negative.");
        }

        Product saved = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping("/category")
    public List<Product> filterByCategory(
        @RequestParam String  name
    ){
        return productService.getProductsByCategoryName(name);
    }
}
