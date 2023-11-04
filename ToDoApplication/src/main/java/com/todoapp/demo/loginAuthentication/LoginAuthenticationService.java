package com.todoapp.demo.loginAuthentication;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {

	public boolean authenticate(String username, String password) {
		boolean isValidUser = username.equalsIgnoreCase("Nikhil");
		boolean isValidPassword = password.equalsIgnoreCase("Dummy");
		
		return isValidUser&&isValidPassword;
	}
}
