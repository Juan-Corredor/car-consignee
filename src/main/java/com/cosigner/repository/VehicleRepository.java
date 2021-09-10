package com.cosigner.repository;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cosigner.model.Vehicle;




@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	Optional<Vehicle> findByenrollment(String enrollment);
	
	@Query("SELECT v FROM Vehicle v WHERE v.id = :id")
	Vehicle findByVehicleId(@Param("id")  Long id);
	
	@Query("SELECT v FROM Vehicle v ORDER BY v.price ")
	List<Vehicle> findAllOrder();

}
