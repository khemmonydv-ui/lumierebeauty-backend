package com.flashsolution.lumierebeauty.service;
import com.flashsolution.lumierebeauty.entity.Brand;
import com.flashsolution.lumierebeauty.repository.BrandRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service 
public class BrandService {
    private final BrandRepository brandRepository;
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository; 

    }
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
    public Brand updateBrand(Long id, Brand updatedBrand) {
        return brandRepository.findById(id)
                .map(brand -> {
                    brand.setName(updatedBrand.getName());
                    brand.setDescription(updatedBrand.getDescription());
                    return brandRepository.save(brand);
                })
                .orElse(null);
    }

    

}
