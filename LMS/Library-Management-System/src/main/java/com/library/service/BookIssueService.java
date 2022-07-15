package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(BookIssue.class);
	

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
	
	public BookIssue findTransactionByTransactionId(Long id){
		log.info("Book issued service called for finding transaction by id.");
		return bookIssueRepository.findById(id).orElse(null);
	}
	
	public List<BookIssue> findTransactionByStatus(String name){	
		log.info("Book issued service called for finding transaction by name.");
		return bookIssueRepository.findBytransactionStatus(name);
	}
	

	public BookIssue updateTransaction(BookIssue bookIssuedTransaction) {
		log.info("Book issued service called for updating transaction.");
		BookIssue existingProduct = bookIssueRepository.findById(bookIssuedTransaction.getTransactionId()).orElse(null);
		existingProduct.setActualBookReturnDate(bookIssuedTransaction.getActualBookReturnDate());
		existingProduct.setBookIssueDate(bookIssuedTransaction.getBookIssueDate());
		existingProduct.setBookReturnDate(bookIssuedTransaction.getBookReturnDate());
		existingProduct.setCreatedOn(bookIssuedTransaction.getCreatedOn());
		existingProduct.setIssuedBy(bookIssuedTransaction.getIssuedBy());
		existingProduct.setRemarks(bookIssuedTransaction.getRemarks());
		existingProduct.setTransactionStatus(bookIssuedTransaction.getTransactionStatus());
		existingProduct.setIssuedTo(bookIssuedTransaction.getIssuedTo());
		existingProduct.setBook(bookIssuedTransaction.getBook());
		existingProduct.setCreatedBy(bookIssuedTransaction.getCreatedBy());
		existingProduct.setModifiedBy(bookIssuedTransaction.getModifiedBy());
		existingProduct.setModifiedOn(bookIssuedTransaction.getModifiedOn());
		return bookIssueRepository.save(existingProduct);		
	}

}

