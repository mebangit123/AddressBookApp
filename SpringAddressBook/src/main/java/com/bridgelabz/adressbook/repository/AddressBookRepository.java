package com.bridgelabz.adressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.adressbook.entity.MyAddressBook;

public interface AddressBookRepository extends JpaRepository<MyAddressBook, Integer> {}