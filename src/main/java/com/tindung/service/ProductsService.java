package com.tindung.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tindung.service.*;
import com.tindung.repository.*;
import com.tindung.model.*;

@Service
public interface ProductsService {
    Product findById(Integer productID);

    // Tìm các sản phẩm cùng loại với một productID cụ thể
    List<Product> getRelateditemsExcludingCurrent(Integer categoryID, Integer currentItemID);

    // List<Product> getProductsByBrand(Integer brandID);

    // List<Product> getProductsByCategory(Integer categoryID);

    List<Product> getProductsByPrice(Double price);

    List<Product> getProductsByCategory(int categoryID);

    List<Brand> getBrandsByCategory(int categoryID);
}
