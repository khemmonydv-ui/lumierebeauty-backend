package com.flashsolution.lumierebeauty.service;

import com.flashsolution.lumierebeauty.entity.Product;
import com.flashsolution.lumierebeauty.repository.ProductRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public
     Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setDescription(updatedProduct.getDescription());
                    product.setPrice(updatedProduct.getPrice());
                    product.setQuantity(updatedProduct.getQuantity());
                    product.setImageUrl(updatedProduct.getImageUrl());
                    product.setCategory(updatedProduct.getCategory());
                    product.setBrand(updatedProduct.getBrand());
                    return productRepository.save(product);
                })
                .orElse(null);
    }
}
