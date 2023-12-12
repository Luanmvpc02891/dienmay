package com.tindung.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindung.service.CategorysService;



@Service
public class CategoryServiceImpl implements CategorysService {
    @Autowired
    com.tindung.repository.categorysRepository categorysRepository;
    //
    public List<Object[]> getRevenueByMonth(int categoryid) {
        return categorysRepository.getRevenueByMonth(categoryid);
    }
}
