package com.tindung.user.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.tindung.config.CookieUtils;
import com.tindung.model.Order;
import com.tindung.model.User;
import com.tindung.repository.UserRepository;


@CrossOrigin("*")
@RestController
public class CheckoutRestcontroller {
  @Autowired
  HttpSession session;

  @Autowired
  CookieUtils cook;

  @Autowired
  UserRepository userDAO;

  @Autowired
  OrdersService orderService;

  @GetMapping("/rest/account")
  public ResponseEntity<User> getAccount(HttpServletRequest req) {
    String email = cook.get("tenDangNhapCookie", req);

    User kh = userDAO.findByEmailLike(email);
    if (kh != null) {
      return ResponseEntity.ok(kh);
    }
    return ResponseEntity.notFound().build();

  }

  @PostMapping("/rest/hoadon")
  public Order create(@RequestBody JsonNode orderData) {
    return orderService.create(orderData);
  }

}
