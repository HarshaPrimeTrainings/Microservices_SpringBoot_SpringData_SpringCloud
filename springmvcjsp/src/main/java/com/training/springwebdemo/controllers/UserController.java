package com.training.springwebdemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.springwebdemo.model.Users;

@Controller
public class UserController {

	
	List<Users> users = new ArrayList<>();
	
	public UserController() {
		
		users.add(new Users(1, "Joe Tribiyani","joe@gmail" ,"123456","HYD"));
		users.add(new Users(2, "Chandler","chandler@gmail" ,"123456","BANG"));
		users.add(new Users(3, "Monika","Monika@gmail" ,"123456","CHANNAI"));
		users.add(new Users(4, "Rachel","Rachel@gmail" ,"123456","PUNE"));
		users.add(new Users(5, "Phebe","Phebe@gmail" ,"123456","ANDAMAN"));
		users.add(new Users(6, "Ross","Ross@gmail" ,"123456","NY"));
		
	}
	
	@RequestMapping(value = {"/users","/"})
	public ModelAndView getUsers() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","Data From Controller");
		mv.addObject("usr", users);
		mv.setViewName("userslist");
		return mv;
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") Users user) {
		users.add(user);
		return "redirect:/users";
	}
	
	@RequestMapping("/adduser")
	public String addUser() {
		return "adduser";
	}
	
	
}
