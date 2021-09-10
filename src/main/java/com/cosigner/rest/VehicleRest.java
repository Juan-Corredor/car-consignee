package com.cosigner.rest;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cosigner.model.Vehicle;
import com.cosigner.service.VehicleService;
import com.cosigner.util.InvalidDataException;






@RestController
@RequestMapping("vehicle")
public class VehicleRest {
	
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping
	public List<Vehicle> getVehicles(){
		return vehicleService.listVehicle();
		
	}
	
	@PostMapping("/create")
	public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle,BindingResult result) {
		
		if (result.hasErrors()) {
			throw new InvalidDataException(result);
		}
		
		return  vehicleService.createVehicle(vehicle);
	}

	@PutMapping(path = "/updateVehicle")
	public Vehicle updateVehicle(@Valid  @RequestBody Vehicle vehicle,BindingResult result) {
		
		if (result.hasErrors()) {
			throw new InvalidDataException(result);
		}

		return vehicleService.updateVehicle(vehicle);
	}
	
	@DeleteMapping(path = "/deleteVehicle/{id}")
	public void deleteVehicle(@PathVariable("id") Long id){
		vehicleService.deleteVehicle(id);
	}

}
