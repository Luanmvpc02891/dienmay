package com.tindung.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tindung.model.Promotion;
import com.tindung.repository.prmotionHistoryRepositpry;
import com.tindung.repository.prmotionRepositpry;

@Controller
public class KhuyenMaiController {
	@Autowired
	prmotionRepositpry prmoDao;

	@Autowired 
	prmotionHistoryRepositpry promoHistoryDao;
	@GetMapping("/khuyenmai")
    public String khuyenmai(Model model) {		
		   List<Promotion> kmlist = prmoDao.findAll();			      		      
	        model.addAttribute("items", kmlist);
        return "taikhoan/khuyenmai";
    }
}
