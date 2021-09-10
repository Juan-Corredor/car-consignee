package com.cosigner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.cosigner.model.Sales;
import com.cosigner.model.Vehicle;
import com.cosigner.repository.SalesRepository;
import com.cosigner.repository.VehicleRepository;

@Service
public class SalesService {

	@Autowired
	SalesRepository salesRepository;
	@Autowired
	VehicleRepository vehicleRepository;
	
	public ArrayList<Sales> listSales(){
		List<Sales> sales = salesRepository.findAllOrder();
		if (sales == null ||   sales.size() == 0) {
			throw new  NoSuchElementException("No Sales");
		}
		return (ArrayList<Sales>) salesRepository.findAllOrder();			
	}
			
	public ArrayList<Sales> listSalesByDate(Sales date){
		
		List<Sales> sales = salesRepository.findBySaleDate(date.getSaleDate());
		if (sales == null ||   sales.size() == 0) {
			throw new  NoSuchElementException("No Sales");
		}
		System.out.println(sales);
		return (ArrayList<Sales>) sales;
	}
	
	public Sales createVentaV(Sales sales) {
		Vehicle vehicleSale = vehicleRepository.findByVehicleId(sales.getVehicle().getId());
	
		
		if (vehicleSale == null) {
			throw new NoSuchElementException("There is no vehicle with id: " + sales.getVehicle().getId());
		}
		
		if(sales.getSaleDate() == null) {
			throw new NoSuchElementException("The date cannot be null.");
		}
		
		try {
			sales.setVehicle(vehicleSale);
			System.out.println(sales);
			return salesRepository.save(sales);	
		} catch (Exception e) {
			throw new DuplicateKeyException("There is already a sale on this vehicle.");
		}
			
		
			
		
	}
		
	public Boolean deleteSale (Long id) {
		Optional<Sales> sale = salesRepository.findById(id);
		
		if(!sale.isPresent()) {
			throw new NoSuchElementException("There is no sale with this id.");
			
		}
		
		try {
			salesRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	 	
}
