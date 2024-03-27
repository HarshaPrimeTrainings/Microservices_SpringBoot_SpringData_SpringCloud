package com.training.springsecuritybasicauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class GreetController {

	@GetMapping("/greet")
	public ModelAndView greet(HttpServletRequest request, HttpServletResponse response, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("greet");
		mav.addObject("remoteUser", request.getRemoteUser());
		return mav;
	}
}
