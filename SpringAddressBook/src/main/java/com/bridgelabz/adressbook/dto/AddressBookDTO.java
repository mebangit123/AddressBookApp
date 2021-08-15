package com.bridgelabz.adressbook.dto;

import lombok.Data;

@Data
public class AddressBookDTO {
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private int phoneNo;
	private String email;
}
