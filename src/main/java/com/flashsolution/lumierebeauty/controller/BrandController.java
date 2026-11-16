package com.flashsolution.lumierebeauty.controller;

import com.flashsolution.lumierebeauty.entity.Brand;
import com.flashsolution.lumierebeauty.service.BrandService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }
}
