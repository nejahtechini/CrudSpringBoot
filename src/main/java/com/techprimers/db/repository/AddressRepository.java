package com.techprimers.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.db.model.UsersAddress;


	public interface AddressRepository extends JpaRepository<UsersAddress, Integer> {

		UsersAddress getByCountryName(String CountryName);


		
	
}
