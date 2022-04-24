package com.example.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.todo.entity.User;
import com.example.todo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService logserv;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/register")
	public String registrationForm(Model m)
	{
		m.addAttribute("user", new User());
		return "registrationForm";
	}
	
	@PostMapping("/process_register")
	public String processRegister(@ModelAttribute User user, BCryptPasswordEncoder passwordEncoder) {
		
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    logserv.addUser(user);
		return "registrationSuccess";
	}
	
	/*
	 * @GetMapping("/login") public String login() { return "login"; }
	 */
}
