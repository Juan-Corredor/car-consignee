package com.cosigner.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cosigner.model.Sales;


public interface SalesRepository extends JpaRepository<Sales ,Long>{
	
	@Query("SELECT s FROM Sales s WHERE s.vehicle.id = :id")
	Sales findByVehicle(@Param("id")  Long id);
	
	@Query("SELECT s FROM Sales s ORDER BY s.vehicle.price ")
	List<Sales> findAllOrder();
	
	@Query("SELECT s FROM Sales s WHERE s.saleDate = :saleDate ORDER BY s.vehicle.price")
	List<Sales> findBySaleDate(@Param("saleDate") LocalDate saleDate);
	
	public List<Sales> findAllBySaleDate(int des);

}
