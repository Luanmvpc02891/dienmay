package com.tindung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tindung.model.Payment;



public interface paymentRepository extends JpaRepository<Payment, Integer>{

}
