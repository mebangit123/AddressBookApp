package com.bridgelabz.adressbook.service;

import java.util.List;

import com.bridgelabz.adressbook.dto.AddressBookDTO;
import com.bridgelabz.adressbook.entity.MyAddressBook;

public interface IAddressBookService {
	List<AddressBookDTO> getAllAddressBook();
	
	MyAddressBook getAddressBookById(int aId);
	
	MyAddressBook addAddressBook(AddressBookDTO addressBookDTO);
	
	MyAddressBook updateAddressBook(int aId, AddressBookDTO addressBookDTO);
	
	void deleteAddressBook(int aId);
}
