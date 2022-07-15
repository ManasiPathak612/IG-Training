package com.library.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
		return userService.getAllUsers();
	}
	@GetMapping("/getUserById/{id}")
	public User findUserById(@PathVariable Long id) {	
		return userService.getUserById(id);
	}

	
	@PostMapping("/addUser")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	@PutMapping("/editUser/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public User updateUser(@RequestBody User user,@PathVariable Long id ){
		user.setUserId(id);
		return userService.editUser(user);
	}
}

