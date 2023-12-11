package com.tindung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tindung.model.New;



public interface newsRepository extends JpaRepository<New, Integer>  {
 
}
