package com.techprimers.db.assembler;

import org.springframework.stereotype.Component;

import com.techprimers.db.model.Users;
import com.techprimers.db.vo.UserGet;
@Component
public class UserAssembler {

public	UserGet convertToUserGet(Users user)

	{
		UserGet userGet = new UserGet();
		userGet.setId(user.getId());
		userGet.setName(user.getName());
		userGet.setSalary(user.getSalary());
		userGet.setTeamName(user.getTeamName());
		if(user.getUserAddress()!=null)
		{
		userGet.setCountryName(user.getUserAddress().getCountryName());
		}
		return userGet;
	}

public Users convertToUsers(UserGet userGet) {
 Users newUser =new Users();

	newUser.setName(userGet.getName());
	newUser.setSalary(userGet.getSalary());
	newUser.setTeamName(userGet.getTeamName());
	return newUser;
}
}
