package com.flashsolution.lumierebeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashsolution.lumierebeauty.entity.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {

}