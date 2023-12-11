package com.tindung.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tindung.service.*;
import com.tindung.repository.*;
import com.tindung.model.*;

public interface commentsRepository extends JpaRepository<Comment, Integer> {

    @Query("SELECT o FROM Comment o where o.product.productID= ?1")
    List<Comment> findByProduct(Integer product);

}
