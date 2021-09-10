package com.cosigner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.cosigner.model.Vehicle;
import com.cosigner.repository.VehicleRepository;



@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleRepo;
	
	public ArrayList<Vehicle> listVehicle(){
		List<Vehicle> vList = vehicleRepo.findAllOrder();
		if (vList == null ||   vList.size() == 0) {
			throw new  NoSuchElementException("No vehicles");
		}

		return (ArrayList<Vehicle>) vehicleRepo.findAllOrder();
	}
	
	public Vehicle createVehicle (Vehicle vehicle) {
		Optional<Vehicle> existVehicle = vehicleRepo.findByenrollment(vehicle.getEnrollment());
		
		if(existVehicle.isPresent() ) {
			throw new DuplicateKeyException("This car already exists: " + vehicle.getEnrollment());
		}
		
		
		return vehicleRepo.save(vehicle);
			
	}
	
	public Vehicle updateVehicle (Vehicle vehicle) {
			return vehicleRepo.save(vehicle);	
	}
	
	public Boolean deleteVehicle (Long id) {
		Optional<Vehicle> vehicle = vehicleRepo.findById(id);
		
		if(!vehicle.isPresent()) {
			throw new NoSuchElementException("There is no vehicle with this id");
			
		}
		try {
			vehicleRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}	  
	}
	
}
