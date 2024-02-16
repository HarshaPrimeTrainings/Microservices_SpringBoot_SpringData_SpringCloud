package com.training.userservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.User;

@RestController
public class UserController {

	List<User> userlist = new ArrayList<User>();
	
	public UserController() {
		userlist.add(new User(1, "vivek", "Hyd", "vivek@gmail.com"));
		userlist.add(new User(2, "anand", "Bang", "anand@gmail.com"));
		userlist.add(new User(3, "ryan", "NY", "ryan@gmail.com"));
		userlist.add(new User(4, "bob", "chennai", "bob@gmail.com"));
		userlist.add(new User(5, "melisa", "chicago", "melisa@gmail.com"));
	}
	
	@RequestMapping("/greet")
	public String greet() {
		return "Hello From UserService";
	}
	
	@RequestMapping(value="/users",method = RequestMethod.GET)
	public List<User> getUsers(){
		return userlist;
	}
	
	@RequestMapping("/user/{uid}")
	public User getUserbyId(@PathVariable int uid) {	
		return userlist.stream().filter(usr -> usr.getUserId() == uid).findAny().orElse(null);
	}
	
	@RequestMapping("/user")
	public User getUserbyIdrequestparam(@RequestParam int uid) {
		return userlist.stream().filter(usr -> usr.getUserId() == uid).findAny().orElse(null);
	}
	
}
