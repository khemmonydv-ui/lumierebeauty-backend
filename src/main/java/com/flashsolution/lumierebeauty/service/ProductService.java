package com.flashsolution.lumierebeauty.service;

import java.util.List;

import com.flashsolution.lumierebeauty.entity.Product;

public interface  ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
}