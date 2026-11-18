package com.flashsolution.lumierebeauty.repository;

import com.flashsolution.lumierebeauty.entity.Brand;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findByNameContainingIgnoreCase(String name);
    List<Brand> findByDescriptionContainingIgnoreCase(String description);
    
    
} 

