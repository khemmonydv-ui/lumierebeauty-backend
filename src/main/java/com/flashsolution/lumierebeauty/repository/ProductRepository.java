package com.flashsolution.lumierebeauty.repository;

import com.flashsolution.lumierebeauty.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByDescriptionContainingIgnoreCase(String description);
    List<Product> findByBrandNameContainingIgnoreCase(String brandName);
    List<Product> findByCategoryNameContainingIgnoreCase(String categoryName);
    Lis
}
