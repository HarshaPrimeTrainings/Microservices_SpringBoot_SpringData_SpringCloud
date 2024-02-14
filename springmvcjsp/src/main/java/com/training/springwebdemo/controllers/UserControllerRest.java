package com.training.springwebdemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springwebdemo.model.Users;

@RestController
public class UserControllerRest {

	
	@RequestMapping("/greet")
	public String greet() {
		return "Hello";
	}
	
	@RequestMapping("/userlist")
	public List<Users> getUsers(){
		List ul = new ArrayList<>();
		ul.add(new Users(1, "Joe Tribiyani","joe@gmail" ,"123456","HYD"));
		ul.add(new Users(2, "Chandler","chandler@gmail" ,"123456","BANG"));
		ul.add(new Users(3, "Monika","Monika@gmail" ,"123456","CHANNAI"));
		ul.add(new Users(4, "Rachel","Rachel@gmail" ,"123456","PUNE"));
		ul.add(new Users(5, "Phebe","Phebe@gmail" ,"123456","ANDAMAN"));
		ul.add(new Users(6, "Ross","Ross@gmail" ,"123456","NY"));
		
		return ul;
	}
}
