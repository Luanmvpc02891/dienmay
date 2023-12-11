package com.tindung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tindung.model.Inventory;



public interface inventoryRepository extends JpaRepository<Inventory, Integer> {
  // @Query("SELECT i FROM Inventory i WHERE i.product.productID = :productId")
  // Inventory findByProductID(@Param("productId") Integer productId);

}
