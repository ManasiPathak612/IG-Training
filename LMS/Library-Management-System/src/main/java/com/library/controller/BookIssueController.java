package com.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.BookIssue;
import com.library.service.BookIssueService;

@RestController
public class BookIssueController {
	@Autowired
	BookIssueService bookIssueService;
	

	private static final Logger log = LoggerFactory.getLogger(BookIssueController.class);
	
	@GetMapping("/getBookTransactions")
	public List<BookIssue> getBookTransaction() {
		return (List<BookIssue>) bookIssueService.getAllTransactions();
	}
	
	@PostMapping("/issueBook/{libId}/{userId}/{bookId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public BookIssue issueBook(@RequestBody BookIssue bookIssue,@PathVariable Long libId, @PathVariable Long userId,
			@PathVariable Long bookId) {
		return bookIssueService.createBookIssue(bookIssue, bookId, userId, libId);
	}
	@GetMapping("/getTransactionByTransactionId/{id}")
	public BookIssue getTransactionByTransactionId(@PathVariable Long id) {
		log.info("Book issued controller called for fetching tranaction by transaction id.");
		return bookIssueService.findTransactionByTransactionId(id);
	}

	@GetMapping("/getTransactionByStatus/{name}")
	public List<BookIssue> getTransactionByStatus(@PathVariable String name) {
		log.info("Book issued controller called for fetching transaction by status.");
		return bookIssueService.findTransactionByStatus(name);
	}

	@PutMapping("/updateTransaction")
	@ResponseStatus(HttpStatus.CREATED)
	public BookIssue updateProduct(@RequestBody BookIssue book) {
		log.info("Book issued controller called for updating transaction ");
		return bookIssueService.updateTransaction(book);

	}
}

