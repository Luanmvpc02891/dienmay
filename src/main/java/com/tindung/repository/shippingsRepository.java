package com.tindung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tindung.service.*;
import com.tindung.repository.*;
import com.tindung.model.*;

public interface shippingsRepository extends JpaRepository<Shipping, Integer> {

}
