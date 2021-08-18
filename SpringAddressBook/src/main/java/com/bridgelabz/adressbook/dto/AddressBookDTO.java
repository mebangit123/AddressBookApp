package com.bridgelabz.adressbook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressBookDTO {
	
	public AddressBookDTO() {
	}

	@Pattern(message = "Firstname is Invalid", regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$")
	private String firstName;
	
	@Pattern(message = "Lastname is Invalid", regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$")
	private String lastName;
	
	@NotBlank(message = "Address cannot be Empty")
	private String address;
	
	@NotBlank(message = "City cannot be Empty")
	private String city;
	
	@NotBlank(message = "State cannot be Empty")
	private String state;
	

	private int zip;
	
//	@Pattern(message = "Invalid Phone Number", regexp = "^([0-9]{2}[\\s])?[1-9][0-9]{9}$")
	private int phoneNo;
	
	@NotBlank(message = "Email cannot be Empty")
	private String email;
}
