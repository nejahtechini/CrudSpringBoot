package com.techprimers.db.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techprimers.db.assembler.UserAssembler;
import com.techprimers.db.exception.DuplicationCountryException;
import com.techprimers.db.exception.ResourceNotFoundException;
import com.techprimers.db.model.Users;
import com.techprimers.db.model.UsersAddress;
import com.techprimers.db.repository.AddressRepository;
import com.techprimers.db.repository.UsersRepository;
import com.techprimers.db.vo.UserGet;

@Service
public class UserService {
	@Autowired
	UsersRepository userRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	UserAssembler userAssembler;

	public List<UserGet> findAllUserGet()

	{
		List<UserGet> listUserGet = new ArrayList<UserGet>();
		List<Users> listUsers = userRepository.findAll();
		listUsers.forEach(item -> {

			listUserGet.add(userAssembler.convertToUserGet(item));

		});

		return listUserGet;
	}

	public void createUsers(UserGet userGet) throws DuplicationCountryException {
		Users newUser = userAssembler.convertToUsers(userGet);

		addAddressToUser(userGet, newUser);
		userRepository.save(newUser);

	}

	void addAddressToUser(UserGet userGet, Users users) throws DuplicationCountryException {
		String country = userGet.getCountryName();
		UsersAddress userAddress = addressRepository.getByCountryName(country);
		if (userAddress != null) {
			throw new DuplicationCountryException(country, "country already exist : one to one mapping");

		} else {
			users.setUserAddress(new UsersAddress(country));
		}

	}
}
