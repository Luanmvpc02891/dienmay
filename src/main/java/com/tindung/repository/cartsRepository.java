package com.tindung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tindung.model.Cart;



public interface cartsRepository extends JpaRepository<Cart, Integer>{
    @Query("SELECT o FROM Cart o where o.user.userID =?1")
    Cart findByUserID(Integer makh);
}
