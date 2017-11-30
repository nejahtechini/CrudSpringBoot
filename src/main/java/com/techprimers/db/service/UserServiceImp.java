package com.techprimers.db.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techprimers.db.exception.DuplicationCountryException;
import com.techprimers.db.exception.ResourceNotFoundException;
import com.techprimers.db.model.Users;
import com.techprimers.db.repository.UsersRepository;
import com.techprimers.db.vo.UserGet;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UsersRepository userRepository;

	public Page<Users> findUserPage(Pageable pageable) {
	//	List<UserGet> listUserGet = new ArrayList<UserGet>();
//		Sort sort = new Sort(new Sort.Order(Direction.ASC, "name"));
//		Pageable pageable = new PageRequest(0, 2, sort);	
//		listUsers.forEach(item -> {
//			listUserGet.add(mapper.map(item, UserGet.class));
//		});
//		return listUserGet;
		Page<Users> listUsers =  userRepository.findAll( pageable) ;
		return listUsers ;
	}

	public Users createUsers(Users user) throws DuplicationCountryException {
		 	return userRepository.save(user);
		  	}

	public Users findByName(String name) {
  		Users user = userRepository.findByName(name);
 	if(user==null)
 	{
 			throw new ResourceNotFoundException(name, "User Not Found");	
 		}
  		return user ;
//  		mapper.map(user, UserGet.class, "getUserFrom");
  	}
	
	
	

	public List<Users> findAllUser() {
		List<Users> listUser = new ArrayList<Users>();

         listUser =   userRepository.findAll();

		return listUser ;
	
}}