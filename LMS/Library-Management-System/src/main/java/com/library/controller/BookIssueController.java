package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.BookIssue;
import com.library.service.BookIssueService;

@RestController
public class BookIssueController {
	@Autowired
	BookIssueService bookIssueService;
	
	@GetMapping("/getBookTransactions")
	public List<BookIssue> getBookTransaction() {
		return (List<BookIssue>) bookIssueService.getAllTransactions();
	}
	
	@PostMapping("/issueBook/{libId}/{userId}/{bookId}")
	public BookIssue issueBook(@RequestBody BookIssue bookIssue,@PathVariable Long libId, @PathVariable Long userId,
			@PathVariable Long bookId) {
		return bookIssueService.createBookIssue(bookIssue, bookId, userId, libId);
	}
	
}

