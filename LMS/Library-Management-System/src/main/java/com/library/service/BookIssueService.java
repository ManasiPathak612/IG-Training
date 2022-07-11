package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.BookIssue;
import com.library.model.User;
import com.library.repository.BookIssueRepository;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;

@Service
public class BookIssueService {
	@Autowired
	BookIssueRepository bookIssueRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookRepository bookRepository;
	

	public List<BookIssue> getAllTransactions(){
		List<BookIssue> bookIssue = new ArrayList<BookIssue>();  
		bookIssueRepository.findAll().forEach(bookIssues -> bookIssue.add(bookIssues));  
		return bookIssue;
	}
	public BookIssue createBookIssue(BookIssue bookIssue,Long bookId,Long userId,Long libId) {
		User user = userRepository.findById(userId).get();
		User librId = userRepository.findById(libId).get();
		Book book = bookRepository.findById(bookId).get();
		bookIssue.setBook(book);
		bookIssue.setIssuedTo(user);
		bookIssue.setIssuedBy(librId);
		bookIssue.setCreatedBy(librId);
		bookIssue.setModifiedBy(librId);
		return bookIssueRepository.save(bookIssue);
	}

}

