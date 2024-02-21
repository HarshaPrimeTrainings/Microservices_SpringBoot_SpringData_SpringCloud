package com.training.userservice.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.dao.User;
import com.training.userservice.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	UserService service;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello From UserService";
	}
	
	@GetMapping(value="/users")
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/user/{uid}")
	public User getUserbyId(@PathVariable int uid) {	
		return service.getUserById(uid);
	}
	
	@GetMapping("/user")
	public User getUserbyIdrequestparam(@RequestParam int uid) {
		return service.getUserById(uid);
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@PutMapping("/update/{userid}")
	public User updateEntireUser(@PathVariable int userid,@RequestBody User user) {
		return service.updateUser(userid, user);
	}
	
	
	@PatchMapping("/updateuser/{userid}")
	public User updateUser(@PathVariable int userid,@RequestBody User user) {
		return service.updatePatch(userid, user);
	}
	
	@PatchMapping("/updatefeild/{userId}")
	public User updateUserFeild(@PathVariable Integer userId, @RequestBody Map<String, String> feildMap) {
		return service.updatePatchReflection(userId, feildMap);
	}
	
	
	@DeleteMapping(value = "/delete/{userid}")
	public String deleteuser(@PathVariable int userid) {
		return service.deleteUser(userid);
	}
}
