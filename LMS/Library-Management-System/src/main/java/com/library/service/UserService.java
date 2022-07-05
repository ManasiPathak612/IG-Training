package com.library.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers()   
	{  
		List<User> users = new ArrayList<User>();  
		userRepository.findAll().forEach(user1 -> users.add(user1));  
		return users;
	}  
	public User addUser(User users)   
	{  
		return userRepository.save(users);  
	}  
}
