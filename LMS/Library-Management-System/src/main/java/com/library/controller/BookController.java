package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Book;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;
import com.library.service.BookService;
import com.library.service.UserService;


@RestController
public class BookController {
	@Autowired  
	BookService booksService;  
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getAllBook")
	public List<Book> getBook(){
		return (List<Book>) booksService.findAllBooks();
	}
	
	@PostMapping("/addBook/{id}")
	public String insertBook(@RequestBody Book book,@PathVariable Long id) {
		booksService.saveBook(book,id);
		return "Book is added successfully!!";
	}
	@PutMapping("/editBook/{id}")
	public String updateBook(@RequestBody Book book,@PathVariable Long id ){
		book.setBookId(id);
		booksService.editBook(book);
		return "Book upddated successfully!";	
	}
	@GetMapping("/searchBookByName/name")
	public ResponseEntity<List<Book>> getBookByName(@RequestParam String name){
		return booksService.searchByName(name);
	}
	@GetMapping("/searchBookByAuthor/name")
	public ResponseEntity<List<Book>> getBookByAuthor(@RequestParam String name){
		return booksService.searchByAuthor(name);
	}
	@GetMapping("/searchBookByPublication/name")
	public ResponseEntity<List<Book>> getBookByPublication(@RequestParam String name){
		return booksService.searchByPublication(name);
	}

	@DeleteMapping("/deleteBookByName/{name}/{id}")
	public String deleteBook(@PathVariable String name, @PathVariable Long id) {
		booksService.deleteBook(name, id);
		return "Book deleted sucessfully!";
	}
}
