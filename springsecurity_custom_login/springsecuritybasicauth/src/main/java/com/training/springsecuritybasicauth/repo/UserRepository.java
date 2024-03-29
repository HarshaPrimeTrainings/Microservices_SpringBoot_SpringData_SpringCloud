package com.training.springsecuritybasicauth.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.training.springsecuritybasicauth.dao.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	public Optional<User> findByUsername(String username);
	
}
