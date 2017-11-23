package com.techprimers.db.model;

import javax.persistence.*;

@Entity
@Table(name = "users_address")
public class UsersAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String countryName;
	@OneToOne(mappedBy = "userAddress")
	private Users user;

	public UsersAddress(String country) {
		this.countryName = country;
	}

	public UsersAddress() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public UsersAddress setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getCountryName() {
		return countryName;
	}

	public UsersAddress setCountryName(String countryName) {
		this.countryName = countryName;
		return this;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
