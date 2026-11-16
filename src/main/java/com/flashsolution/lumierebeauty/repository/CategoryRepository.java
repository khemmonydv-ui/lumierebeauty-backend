
package com.flashsolution.lumierebeauty.repository;

import com.flashsolution.lumierebeauty.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
