
package com.flashsolution.lumierebeauty.repository;

import com.flashsolution.lumierebeauty.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Used by DataSeeder: true if a category with this exact name exists
    boolean existsByName(String name);

}
