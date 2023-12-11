package com.tindung.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindung.service.*;
import com.tindung.repository.*;

@Service
public class BrandServiceImpl implements BrandsService {
    @Autowired
    brandsRepository brandsRepository;

    public List<Object[]> getRevenueByMonth(int brandId) {
        return brandsRepository.getRevenueByMonth(brandId);
    }

}
