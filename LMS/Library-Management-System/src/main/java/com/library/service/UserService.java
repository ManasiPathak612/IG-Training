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
		return userRepository.findAll(); 
	}  
	public User addUser(User user)   
	{  
		return userRepository.save(user);  
	}
	public User editUser(User user) {
		User user1 = userRepository.findById(user.getUserId()).orElse(null);
		user1.setUserName(user.getUserName());
		user1.setUserAddress(user.getUserAddress());
		user1.setUserMailId(user.getUserMailId());
		user1.setUserType(user.getUserType());
		user1.setUserAge(user.getUserAge());
		user1.setGender(user.getGender());
		return userRepository.save(user1);
	}  
	public User getUserById(Long id) {
		return userRepository.findByUserId(id);
	}
}
