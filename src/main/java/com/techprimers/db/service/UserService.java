package com.techprimers.db.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.techprimers.db.exception.DuplicationCountryException;
import com.techprimers.db.model.Users;

public interface UserService {
	public Page<Users> findUserPage(Pageable pageable) ;
	public Users createUsers(Users user) throws DuplicationCountryException ;
	public Users findByName(String name)  ;
}