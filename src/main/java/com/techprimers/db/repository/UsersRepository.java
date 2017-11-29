package com.techprimers.db.repository;

import com.techprimers.db.model.Users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRepository extends PagingAndSortingRepository<Users, Integer> {
    Page <Users> findAll(Pageable pageable) ;
	Users findByName(String name);
	List <Users>findAll();
	
}
