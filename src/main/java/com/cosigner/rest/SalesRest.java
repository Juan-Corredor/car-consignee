package com.cosigner.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cosigner.model.Sales;
import com.cosigner.service.SalesService;

@RestController
@RequestMapping("sale")
public class SalesRest {

	@Autowired
	SalesService salService;
	
	@GetMapping("/")
	public List<Sales> getVehicles(){
		return salService.listSales();	
	}
	
	@GetMapping("/date")
	public ArrayList<Sales> getVehiclesDate(@RequestBody Sales date){
		return salService.listSalesByDate(date);
	}
	
	@PostMapping("/create")
	public Sales createSale(@RequestBody Sales sales){
		return salService.createVentaV(sales);
	}
	
	@DeleteMapping(path = "/deleteSale/{id}")
	public void deleteSale(@PathVariable("id") Long id){			
		 salService.deleteSale(id);
	}
}
