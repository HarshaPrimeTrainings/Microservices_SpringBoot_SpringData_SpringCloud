package com.training.springsecuritybasicauth.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springsecuritybasicauth.dao.Roles;
import com.training.springsecuritybasicauth.dao.User;
import com.training.springsecuritybasicauth.dto.UserDto;
import com.training.springsecuritybasicauth.enums.Role;
import com.training.springsecuritybasicauth.repo.RoleRepository;
import com.training.springsecuritybasicauth.repo.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@Autowired
	RoleRepository rolerepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody UserDto userdto) {
		Set<Roles> roles = new HashSet<>();
		userdto.getRoles().forEach(role->{
			 Roles userrole= rolerepo.findByRole(Role.valueOf(role)).orElseThrow(()->new RuntimeException("No role has found"));
			roles.add(userrole);
		});
		
		User user = new User();
		user.setUsername(userdto.getUsername());
		user.setPassword(encoder.encode(userdto.getPassword()));
		user.setRoles(roles);
		return repo.save(user);
	}
	
}
