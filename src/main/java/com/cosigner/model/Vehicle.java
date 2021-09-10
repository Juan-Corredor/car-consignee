package com.cosigner.model;


import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import lombok.Data;


@Entity
@Data
@Table(name = "vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "This field is required")
	@Size(min = 1,max = 30, message = "character limit exceeded")
	private String enrollment;

	@NotBlank(message = "This field is required")
	@Size(min = 1,max = 30, message = "character limit exceeded")
	private String model;
	
	@Range(min = 1,message = "The value must be greater than zero and cannot be null.")
	@DecimalMax(value = "100000000" ,message = "must be less than or equal to 100,000,000" )
	private int price;
	
	


	
	
	

}
