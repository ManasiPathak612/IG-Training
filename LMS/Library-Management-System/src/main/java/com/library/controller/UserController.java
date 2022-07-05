package com.library.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.User;
import com.library.service.UserService;


@RestController
public class UserController {
	@Autowired  
	UserService userService;   
	
	@PostMapping("/addUser")
	public String saveUser(@RequestBody User user) {
		userService.addUser(user);
		return "user added successfully!";
	}
}

