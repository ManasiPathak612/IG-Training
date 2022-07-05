package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Book;
import com.library.service.BookService;


@RestController
public class BookController {
	@Autowired  
	BookService booksService;  
	
	@PostMapping("/addBook")
	public String insertBook(@RequestBody Book book) {
		booksService.save(book);
		return "Book is added successfully!!";
	}
	@PutMapping("/editBook/{id}")
	public String updateBook(@RequestBody Book book,@PathVariable Long id ){
		book.setBookId(id);
		booksService.editBook(book);
		return "Book upddated successfully!";
		
	}
}
