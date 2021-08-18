package com.bridgelabz.adressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.bridgelabz.adressbook.dto.AddressBookDTO;
import com.bridgelabz.adressbook.dto.ResponseDTO;
import com.bridgelabz.adressbook.entity.MyAddressBook;
import com.bridgelabz.adressbook.service.IAddressBookService;

/**
 * Defining REST call for different HTTP Methods;
 */
@RestController
@RequestMapping("/api")
public class AddressBookController {
	
	@Autowired
	private IAddressBookService addressBookService;
	
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getAllAddressBookData() {
		List<AddressBookDTO> addressBookDTOList = null;
		addressBookDTOList = addressBookService.getAllAddressBook();
		return new ResponseEntity<>(new ResponseDTO("List of AddressBook", addressBookDTOList), HttpStatus.OK);
	}

	@GetMapping("/get/{Id}")
	public ResponseEntity<ResponseDTO> findById(@PathVariable("Id") int id) {		
		MyAddressBook addressBook = addressBookService.getAddressBookById(id);
		AddressBookDTO addressBookDTO = new AddressBookDTO();
		BeanUtils.copyProperties(addressBook, addressBookDTO);
		return new ResponseEntity<>(new ResponseDTO("Get AddressBook by Id", addressBookDTO), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		MyAddressBook addressBook = null;
		addressBook = addressBookService.addAddressBook(addressBookDTO);
		AddressBookDTO addressDTO = new AddressBookDTO();
		BeanUtils.copyProperties(addressBook, addressDTO);
		ResponseDTO respDTO = new ResponseDTO("AddressBook Created Successfully", addressDTO);
		return new ResponseEntity<>(respDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{Id}")
	public ResponseEntity<ResponseDTO> updateAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO, @PathVariable("Id") int Id) {
		MyAddressBook addressBook = null;
		addressBook = addressBookService.updateAddressBook(Id, addressBookDTO);
		AddressBookDTO addressDTO = new AddressBookDTO();
		BeanUtils.copyProperties(addressBook, addressDTO);
		return new ResponseEntity<>(new ResponseDTO("AddressBook updated!",addressDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable("Id") int Id) {
		addressBookService.deleteAddressBook(Id);
		return new ResponseEntity<>(new ResponseDTO("Deleted Successfully","Deleted for Id :"+Id),HttpStatus.OK);
	}
}