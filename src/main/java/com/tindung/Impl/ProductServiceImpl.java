package com.tindung.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindung.model.Brand;
import com.tindung.model.Product;
import com.tindung.repository.brandsRepository;
import com.tindung.repository.productsRepository;
import com.tindung.service.ProductsService;


@Service
public class ProductServiceImpl implements ProductsService {
    @Autowired
    productsRepository productsRepository;

    @Autowired
    brandsRepository brandsRepository;

    public Product findById(Integer productID) {
        return productsRepository.findById(productID).get();
    }

    @Override
    public List<Product> getRelateditemsExcludingCurrent(Integer categoryID, Integer currentItemID) {
        return productsRepository.findByCategory_CategoryIDAndProductIDNot(categoryID, currentItemID);
    }

    // @Override
    // public List<Product> getProductsByBrand(Integer brandID) {
    // return productsRepository.findByBrandBrandID(brandID);
    // }

    // @Override
    // public List<Product> getProductsByCategory(Integer categoryID) {
    // return productsRepository.findByCategoryCategoryID(categoryID);
    // }

    @Override
    public List<Product> getProductsByPrice(Double price) {
        return productsRepository.findByPriceLessThanEqual(price);
    }

    @Override
    public List<Product> getProductsByCategory(int categoryID) {
        return productsRepository.findByCategoryCategoryID(categoryID);
    }

    @Override
    public List<Brand> getBrandsByCategory(int categoryID) {
        return brandsRepository.findByProducts_Category_CategoryID(categoryID);
    }
}
