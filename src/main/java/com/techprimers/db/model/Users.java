package com.techprimers.db.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.techprimes.db.validators.Teamname;

@Entity
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @NotNull(message = "Name can not be null.")
    private String name;
    @Column(name = "team_name")
    @Teamname(message = " teamName not equals to <<teamname>>.")
    private String teamName;
    @Column(name = "salary")
    private Integer salary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private UsersAddress userAddress;
    
	public Users() {
		
	}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

	public UsersAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UsersAddress userAddress) {
		this.userAddress = userAddress;
	}

    
}
