package com.flashsolution.lumierebeauty.config;

import com.flashsolution.lumierebeauty.entity.Brand;
import com.flashsolution.lumierebeauty.entity.Category;
import com.flashsolution.lumierebeauty.repository.BrandRepository;
import com.flashsolution.lumierebeauty.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// Runs once every time the backend starts.
// Adds every brand and category below that is not in the database yet.
// Names that already exist are skipped, so nothing is added twice.
@Component
public class DataSeeder implements CommandLineRunner {

    // ===== EDIT THESE LISTS TO ADD ITEMS TO THE DROPDOWNS =====
    // Add a name, then restart the backend.
    // Removing a name here does NOT delete it from the database.
    private static final List<String> BRANDS = List.of(
            "Dior",
            "Rare Beauty",
            "Fenty Beauty",
            "The Ordinary",
            "CeraVe",
            "Beauty of Joseon",
            "Laneige"
    );

    private static final List<String> CATEGORIES = List.of(
            "Skincare",
            "Makeup",
            "Haircare",
            "Body",
            "Fragrance"
    );
    // ===========================================================

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        for (String name : BRANDS) {
            if (!brandRepository.existsByName(name)) {
                Brand brand = new Brand();
                brand.setName(name);
                brandRepository.save(brand);
            }
        }

        for (String name : CATEGORIES) {
            if (!categoryRepository.existsByName(name)) {
                Category category = new Category();
                category.setName(name);
                categoryRepository.save(category);
            }
        }
    }
}
