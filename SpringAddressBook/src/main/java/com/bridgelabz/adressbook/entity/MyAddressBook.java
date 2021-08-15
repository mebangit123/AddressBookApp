package com.bridgelabz.adressbook.entity;

import lombok.Data;

@Data
public class MyAddressBook {

	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private int phoneNo;
	private String email;
	
	public MyAddressBook() {}

	public MyAddressBook(int id, String firstName, String lastName, 
						 String address, String city, String state, int zip,
						 int phoneNo, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.email = email;
	}
}
