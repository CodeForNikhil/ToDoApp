package com.todoapp.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
//	private LoginAuthenticationService authenticationService;
	
	
//	@RequestMapping("login")
//	public String getLogin(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		return "Login";
//	}
	
//	public LoginController(LoginAuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}
	
	
//	@PostMapping(value="/login")
//	public String getWelcome(@RequestParam String name, String password, ModelMap model) {
//		if(authenticationService.authenticate(name, password)) {
//			
//			model.put("name", name);
//			return "Welcome";			
//		}
//		else
//			model.put("errorMessage", "Invalid Credentials, Try again!");
//			return "Login";	
//	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@GetMapping(value="/")
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "Welcome";
	}
}
