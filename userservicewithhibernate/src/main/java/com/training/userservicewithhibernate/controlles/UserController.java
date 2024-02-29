package com.training.userservicewithhibernate.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservicewithhibernate.dao.UserDao;
import com.training.userservicewithhibernate.dao.UserDetails;

@RestController
public class UserController {

	@Autowired
	UserDao dao;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserDetails user) {
		return dao.saveUser(user);
	}
	
	@GetMapping("/users")
	public List<UserDetails> getUsers(){
		return dao.getAllUsers();
	}
	
	@GetMapping("/user/{uid}")
	public UserDetails getUser(@PathVariable Integer uid) {
		return dao.getUsrById(uid);
	}
	
	@DeleteMapping("/delete/{uid}")
	public String deletUser(@PathVariable Integer uid) {
		return dao.deleteuser(uid);
	}
	
	
}
