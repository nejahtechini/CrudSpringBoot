package com.techprimers.db.vo;

public class UsersAddressGet {

	private Integer id;
	private String countryName;
	private UserGet user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public UserGet getUser() {
		return user;
	}

	public void setUser(UserGet user) {
		this.user = user;
	}

}
