package com.tindung;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tindung.service.*;
import com.tindung.repository.*;
import com.tindung.model.*;
import com.tindung.ServiceImpl.*;

@Component
public class PromotionScheduler {

	@Autowired
	prmotionRepositpry prmoDao;

	@Autowired
	UserRepository userDAO;

	@Autowired
	ordersRepository orderDAO;

	@Scheduled(fixedRate = 100000) // sau 10p tự chạy 1 lần
	public void updatePromotionStatus() {
		List<Promotion> kmlist = prmoDao.findAll();
		LocalDateTime currentTime = LocalDateTime.now();

		for (Promotion promo : kmlist) {
			if (currentTime.isAfter(promo.getUsedDates()) && currentTime.isBefore(promo.getDateEnd())) {
				promo.setStatus(true);
			} else {
				promo.setStatus(false);
			}
			prmoDao.save(promo);
		}

	}

	@Scheduled(fixedRate = 100000) // sau 1p tự chạy 1 lần
	public void updateOrder() {
		List<Order> orders = orderDAO.findAll();
		for (Order order : orders) {
			if (order.getStatushd() == 1) {
				Integer tt = orderDAO.findThoiGianDaTao(order.getOrderId());
				System.out.println("Thời gian tạo đơn hàng:" + tt);
				if (tt > 2) {
					order.setStatushd(2);
					orderDAO.save(order);
				}

			}
		}

	}
}