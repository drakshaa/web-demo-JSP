package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	// method without body is called abstract method
		void signup(User u);
		boolean login(String un, String psw);
		
		List<User> getAllUsers();
}
