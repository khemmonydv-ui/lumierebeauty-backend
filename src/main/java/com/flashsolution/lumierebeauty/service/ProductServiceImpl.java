package com.flashsolution.lumierebeauty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flashsolution.lumierebeauty.entity.Product;
import com.flashsolution.lumierebeauty.repository.ProductRepository;

@Service 
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override 
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override 
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
