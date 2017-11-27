package com.techprimers.db.service;

import java.util.List;

import com.techprimers.db.exception.DuplicationCountryException;
import com.techprimers.db.model.Users;
import com.techprimers.db.vo.UserGet;

public interface UserService {
	public List<UserGet> findAllUserGet() ;
	public Users createUsers(Users user) throws DuplicationCountryException ;
	public Users findByName(String name)  ;
}