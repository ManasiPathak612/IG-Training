package com.library.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;

@Service
public class BookService {
	@Autowired
	BookRepository booksRepository;
	
	@Autowired
	UserRepository userRepository;

	
	public List<Book> getAllBooks()   
	{  
		List<Book> books = new ArrayList<Book>();  
		booksRepository.findAll().forEach(books1 -> books.add(books1));  
		return books;
	}  
	public void saveBook(Book books,Long id)   
	{  
		User user = userRepository.findById(id).get();
		books.setCreatedBy(user);
		books.setModifiedBy(user);
		booksRepository.save(books);  
	}
	public Book editBook(Book book) {
		Book book1 = booksRepository.findById(book.getBookId()).orElse(null);
		book1.setBookName(book.getBookName());
		book1.setBookAuthor(book.getBookAuthor());
		book1.setBookPrice(book.getBookPrice());
		book1.setBookPublication(book.getBookPublication());
		book1.setNoOfCopies(book.getNoOfCopies());
		book1.setNoOfCopies(book.getNumberOfPages());
		return booksRepository.save(book1);
	}  
	
	public List<Book> findAllBooks() {
		return booksRepository.findAll();
	}
	public List<Book> searchByName(String name){
		return booksRepository.findByBookName(name);
	}
	public ResponseEntity<List<Book>> searchByAuthor(String name){
		return new ResponseEntity<List<Book>>(booksRepository.findByBookAuthor(name),HttpStatus.OK);
	}
	public ResponseEntity<List<Book>> searchByPublication(String name){
		return new ResponseEntity<List<Book>>(booksRepository.findByBookPublication(name),HttpStatus.OK);
	}
	public Book deleteBook(String name, Long id) {
		List<Book> existingBook = booksRepository.findByBookName(name);
		User user = userRepository.findById(id).get();
		existingBook.get(0).setActiveFlag(0);
		existingBook.get(0).setNoOfCopies(0);
		existingBook.get(0).setModifiedBy(user);
		return booksRepository.save(existingBook.get(0));
	}
	public Book saveBook(Book book) {
		return booksRepository.save(book);
	}
	public Book saveBookInfo(Book book) {
		return booksRepository.save(book);
	}
	
	
}

