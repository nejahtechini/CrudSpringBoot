package com.techprimers.db.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techprimers.db.exception.DuplicationCountryException;
import com.techprimers.db.exception.ResourceNotFoundException;
import com.techprimers.db.model.Users;
import com.techprimers.db.repository.UsersRepository;
import com.techprimers.db.vo.UserGet;

@Service
public class UserService {

	@Autowired
	UsersRepository userRepository;

	@Autowired
	DozerBeanMapper mapper;

	public List<UserGet> findAllUserGet() {
		List<UserGet> listUserGet = new ArrayList<UserGet>();
		List<Users> listUsers = userRepository.findAll();
		listUsers.forEach(item -> {
			listUserGet.add(mapper.map(item, UserGet.class));
		});
		return listUserGet;
	}

	public Users createUsers(Users user) throws DuplicationCountryException {
		return userRepository.save(user);
	}

	public UserGet findByName(String name) {
		Users user = userRepository.findByName(name);
		if(user==null)
		{
			throw new MappingException(name);	
		}
		return mapper.map(user, UserGet.class, "getUserFrom");
	}
}