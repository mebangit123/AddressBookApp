package com.bridgelabz.adressbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.adressbook.dto.ResponseDTO;
import com.bridgelabz.adressbook.entity.MyAddressBook;

/**
 * Defining REST call for different HTTP methods;
 */
@RestController
@RequestMapping("/api")
public class AddressBookController {
	
	private List<MyAddressBook> addressbookList = new ArrayList<>();
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody MyAddressBook addressBook) {
		addressbookList.add(addressBook);
		ResponseDTO respDTO = new ResponseDTO("AddressBook Created Successfully", addressBook);
		return new ResponseEntity<>(respDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAllAddressBookData() {
		return new ResponseEntity<>(new ResponseDTO("List of AddressBook", addressbookList), HttpStatus.OK);
	}
	
	public MyAddressBook findByAId(int id) {
		MyAddressBook addressBook =addressbookList.stream().filter(addressbook -> addressbook.getId() == id)
				.findFirst()
				.orElseThrow();
		return addressBook;
	}
	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> findById(@PathVariable("Id") int id) {		
		MyAddressBook addressBook = this.findByAId(id);
		return new ResponseEntity<>(new ResponseDTO("Get AddressBook by Id", addressBook), HttpStatus.OK);
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateAddressBook(@RequestBody MyAddressBook addressBook, @PathVariable("Id") int Id) {
		addressBook = this.findByAId(Id);
		return new ResponseEntity<>(new ResponseDTO("AddressBook updated!",addressBook), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable("Id") int Id) {
		addressbookList.remove(Id);
		return new ResponseEntity<>(new ResponseDTO("Deleted Successfully","Deleted for Id :"+Id),HttpStatus.OK);
	}
}