package com.library.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.library.model.BookIssue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookIssueRepositoryTest {
	@Autowired
	BookIssueRepository bookIssueRepository;
	
	private BookIssue bookIssue;
	
	@BeforeEach
	public void setUp() {
		bookIssue = BookIssue.builder().remarks("Approved").
				transactionStatus("Transaction Approved").build();
	}
	@Test
	public void givenBookIssuedObject_whenFindAll_thenReturnBookList() {
		bookIssueRepository.save(bookIssue);
		BookIssue book = bookIssueRepository.
		findById(bookIssue.getTransactionId()).get();
		assertThat(book).isNotNull();		
	}
	@Test
	public void givenBookListObject_whenFindAll_thenReturnBookList() {
		bookIssueRepository.save(bookIssue);
		List<BookIssue> transactionList = bookIssueRepository.findAll();
		assertThat(transactionList).isNotNull();
		assertThat(transactionList.size()).isGreaterThanOrEqualTo(6);
	}
	@Test
	public void givenBookObject_whenUpdate_thenReturnBookIssue() {
		bookIssueRepository.save(bookIssue);
		BookIssue savedTransaction = bookIssueRepository.findById(bookIssue.getTransactionId()).get();
		savedTransaction.setRemarks("Rejected");
		savedTransaction.setTransactionStatus("Book is not available");
		BookIssue bookUpdated = bookIssueRepository.save(savedTransaction);
		assertThat(bookUpdated.getRemarks()).isEqualTo("Rejected");
		assertThat(bookUpdated.getTransactionStatus()).isEqualTo("Book is not available");
	}
	@Test
	public void givenBookObject_whengetTransactionStatus_thenReturnBookIssue() {
		bookIssueRepository.save(bookIssue);
		List<BookIssue> savedUser = bookIssueRepository.findBytransactionStatus(bookIssue.getTransactionStatus());
		assertThat(savedUser).isNotNull();
	}
	@Test
	public void givenBookObject_whenFindById_thenReturnBook() {
		bookIssueRepository.save(bookIssue);
		BookIssue savedTransaction = bookIssueRepository.findById(bookIssue.getTransactionId()).get();
		assertThat(savedTransaction).isNotNull();
	}
}
