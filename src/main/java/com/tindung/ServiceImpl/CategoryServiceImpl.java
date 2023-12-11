package com.tindung.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tindung.service.*;
import com.tindung.repository.*;

@Service
public class CategoryServiceImpl implements CategorysService {
    @Autowired
    categorysRepository categorysRepository;

    //
    public List<Object[]> getRevenueByMonth(int categoryid) {
        return categorysRepository.getRevenueByMonth(categoryid);
    }
}
