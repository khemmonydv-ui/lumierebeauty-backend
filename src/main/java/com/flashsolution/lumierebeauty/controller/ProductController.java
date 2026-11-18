package com.flashsolution.lumierebeauty.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flashsolution.lumierebeauty.entity.Product;
import com.flashsolution.lumierebeauty.service.ProductService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping ("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping 
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

    @GetMapping 
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}