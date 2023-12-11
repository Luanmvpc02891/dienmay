package com.tindung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tindung.service.*;
import com.tindung.repository.*;
import com.tindung.model.*;

public interface prmotionRepositpry extends JpaRepository<Promotion, Integer> {

}
