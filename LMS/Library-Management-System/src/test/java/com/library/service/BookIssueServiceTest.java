package com.library.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.library.model.BookIssue;
import com.library.repository.BookIssueRepository;

@ExtendWith(MockitoExtension.class)
public class BookIssueServiceTest {
	
	@Mock
	private BookIssueRepository bookIssueRepository;
	
	@InjectMocks
	private BookIssueService bookIssueService;
	
	@Test
	public void givenBookIssueObject_whenSave_ThenReturnBookIssueObject() {
		BookIssue bookIssue = BookIssue.builder().
				transactionId(1L).bookIssueDate(new Date()).transactionStatus("Approved").
				remarks("Book Issued").build();
		BDDMockito.given(bookIssueRepository.findById(1L)).willReturn(Optional.of(bookIssue));
		BDDMockito.given(bookIssueRepository.save(bookIssue)).willReturn(bookIssue);
		BookIssue savedBook = bookIssueService.createBookIssue(bookIssue,2L,1L,1L);
       	assertThat(savedBook).isNotNull();
	}
	@Test
	public void givenBookIssueObject_whenFindById_thenReturnBookIssueObject() {
		BookIssue	bookIssue1 = BookIssue.builder().transactionId(1L).bookIssueDate(new Date()).transactionStatus("Approved").remarks("Book Issued").build();
		BDDMockito.given(bookIssueRepository.findById(bookIssue1.getTransactionId())).willReturn(Optional.of(bookIssue1));
		BookIssue savedBookIssue = bookIssueService.findTransactionByTransactionId(bookIssue1.getTransactionId());
		assertThat(savedBookIssue).isNotNull();
	}
	@Test
	public void givenBookIssueObject_whenFindByStatus_thenReturnBookIssueObject() {
		BookIssue	bookIssue1 =
				BookIssue.builder().transactionId(1L).bookIssueDate(new Date()).
		transactionStatus("Approved").remarks("Book Issued").build();
		BDDMockito.given(bookIssueRepository.findBytransactionStatus("Approved")).willReturn(List.of(bookIssue1));
		List<BookIssue> savedBookTransaction = bookIssueService.findTransactionByStatus(bookIssue1.getTransactionStatus());
		assertThat(savedBookTransaction).isNotNull();
	}
	@Test
	public void givenUserObject_ForUpdateTransaction_thenReturnUserObject() {
		BookIssue	bookIssue1 = BookIssue.builder().transactionId(1L).bookIssueDate(new Date()).transactionStatus("Approved").remarks("Book Issued").build();
		BDDMockito.given(bookIssueRepository.save(bookIssue1)).willReturn(bookIssue1);
		BookIssue savedUser = bookIssueService.createBookIssue(bookIssue1,2L,1L,1L);
		savedUser.setRemarks("Book is issued");
        assertThat(savedUser.getRemarks()).isEqualTo("Book is issued");
	}
}
