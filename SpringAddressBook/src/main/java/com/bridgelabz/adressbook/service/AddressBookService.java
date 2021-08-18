package com.bridgelabz.adressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.adressbook.dto.AddressBookDTO;
import com.bridgelabz.adressbook.entity.MyAddressBook;
import com.bridgelabz.adressbook.exception.AddressBookException;
import com.bridgelabz.adressbook.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	
	@Autowired
	private AddressBookRepository addressBookRepo;
	
	@Override
	public List<AddressBookDTO> getAllAddressBook() {
		List<MyAddressBook> addressBookList = addressBookRepo.findAll();
		List<AddressBookDTO> addDTO = new ArrayList<>();
		addressBookList.stream().forEach((address) -> 
		{
			AddressBookDTO aDTO = new AddressBookDTO();
			BeanUtils.copyProperties(address, aDTO);
			addDTO.add(aDTO);
		});
		return addDTO;
	}

	@Override
	public MyAddressBook getAddressBookById(int aId) {
		MyAddressBook addressBook =addressBookRepo
									.findById(aId)
									.orElseThrow(() -> new AddressBookException("AddressBook With Id "+aId +" does not Exists..!!"));
		return	addressBook;
	}

	@Override
	public MyAddressBook addAddressBook(AddressBookDTO addressBookDTO) {
		MyAddressBook addressBook = new MyAddressBook();
		BeanUtils.copyProperties(addressBookDTO, addressBook);
		return addressBookRepo.save(addressBook);
	}

	@Override
	public MyAddressBook updateAddressBook(int aId, AddressBookDTO addressBookDTO) {
		MyAddressBook addressBook = this.getAddressBookById(aId);
		BeanUtils.copyProperties(addressBookDTO, addressBook);
		return addressBookRepo.save(addressBook);
	}

	@Override
	public void deleteAddressBook(int aId) {
		MyAddressBook addressBook = getAddressBookById(aId);
		addressBookRepo.delete(addressBook);
	}
}
