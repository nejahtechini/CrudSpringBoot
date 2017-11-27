package com.techprimers.db.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.db.exception.DuplicationCountryException;
import com.techprimers.db.exception.ResourceNotFoundException;
import com.techprimers.db.model.Users;
import com.techprimers.db.repository.UsersRepository;
import com.techprimers.db.service.UserServiceImp;
import com.techprimers.db.vo.UserGet;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	UserServiceImp userService;

	@GetMapping(value = "id/{id}")
	public Users getUserById(@PathVariable("id") Integer id) {
		Users user = usersRepository.findOne(id);
		if (user == null) {
			throw new ResourceNotFoundException(id, "user not found in your dataBase");
		}
		return user;
	}

	@GetMapping(value = "name/{name}")
	public Users getUserByName(@PathVariable("name") String name) {
		Users user = userService.findByName(name);

		if (user == null) {
			throw new ResourceNotFoundException(name, "user not found in your dataBase");
		}
		return user;
	}

	@GetMapping(value = "/all")
	public List<UserGet> getAll() {
		return userService.findAllUserGet();
	}
	
	
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public Users persist(@Valid @RequestBody final Users user) throws DuplicationCountryException {
		System.out.print("---------------------------" + user.getId() + user.getUserAddress().getId());
		 	return userService.createUsers(user);
		  	}
	

	@DeleteMapping(value = "/user/{id}")
	public Boolean deleteUser(@PathVariable Integer id) {
		usersRepository.delete(id);
		return true;
	}

}
