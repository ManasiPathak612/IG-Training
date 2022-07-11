package com.library.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Book;
import com.library.model.User;
import com.library.service.UserService;


@RestController
public class UserController {
	@Autowired  
	UserService userService;   
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		return (List<User>) userService.getAllUsers();
	}
	
	@PostMapping("/addUser")
	public String saveUser(@RequestBody User user) {
		userService.addUser(user);
		return "user added successfully!";
	}
	@PutMapping("/editUser/{id}")
	public String updateUser(@RequestBody User user,@PathVariable Long id ){
		user.setUserId(id);
		userService.editUser(user);
		return "User upddated successfully!";
		
	}
}

