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


}
