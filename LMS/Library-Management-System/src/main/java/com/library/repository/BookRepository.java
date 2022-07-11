package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>  
{

	List<Book> findByBookName(String name);
	List<Book> findByBookAuthor(String bookAuthor);
	List<Book> findByBookPublication(String bookPublication);
} 
