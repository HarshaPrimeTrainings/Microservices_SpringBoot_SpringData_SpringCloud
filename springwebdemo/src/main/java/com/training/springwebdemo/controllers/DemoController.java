package com.training.springwebdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("/greet")
	public String sendGreet() {
		System.out.println("======== DemoCOntroller =========");
		return "hello";
	}
	
	@RequestMapping("/msg")
	public String getMessage() {
		System.out.println("GET Message");
		return "demo";
	}
	

}
