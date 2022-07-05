package com.library.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository booksRepository;
	
	public List<Book> getAllBooks()   
	{  
		List<Book> books = new ArrayList<Book>();  
		booksRepository.findAll().forEach(books1 -> books.add(books1));  
		return books;
	}  
	public void save(Book books)   
	{  
		booksRepository.save(books);  
	}
	public Book editBook(Book book) {
		Book book1 = booksRepository.findById(book.getBookId()).orElse(null);
		book1.setBookName(book.getBookName());
		book1.setBookAuthor(book.getBookAuthor());
		book1.setBookPrice(book.getBookPrice());
		book1.setBookPublication(book.getBookPublication());
		book1.setNoOfCopies(book.getNoOfCopies());
		return booksRepository.save(book1);
	}  
	
}

