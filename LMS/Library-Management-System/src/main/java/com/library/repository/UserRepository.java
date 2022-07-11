package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.library.model.Book;
import com.library.model.User;

public interface UserRepository extends JpaRepository<User, Long>  
{ 
	List<User> findByUserName(String name);
} 
