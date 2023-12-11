package com.tindung.user.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tindung.model.Brand;
import com.tindung.model.Category;
import com.tindung.model.Product;
import com.tindung.repository.brandsRepository;
import com.tindung.repository.categorysRepository;
import com.tindung.repository.productsRepository;
import com.tindung.service.BrandsService;



@CrossOrigin("*")
@RestController
public class BrandRestController {
    @Autowired
    brandsRepository dmdao;

    @Autowired
    categorysRepository categoryRepository;

    @Autowired
    productsRepository productRepository;

    @Autowired
    BrandsService brandService;

    @GetMapping("/rest/brand")
    public ResponseEntity<List<Brand>> findAll() {
        return ResponseEntity.ok(dmdao.findAll());
    }

    @GetMapping("/categories-by-brand/{brandID}")
    public ResponseEntity<List<Category>> getCategoriesByBrand(@PathVariable("brandID") int brandID) {
        List<Category> categories = categoryRepository.findByProducts_Brand_BrandID(brandID);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/products-by-brand/{brandID}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable("brandID") int brandID) {
        List<Product> products = productRepository.findByBrandBrandID(brandID);
        return ResponseEntity.ok(products);
    }
}
