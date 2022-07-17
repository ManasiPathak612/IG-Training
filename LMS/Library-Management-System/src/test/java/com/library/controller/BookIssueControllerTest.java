package com.library.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.Book;
import com.library.model.BookIssue;
import com.library.model.User;
import com.library.service.BookIssueService;

@WebMvcTest(value = BookIssueController.class)
public class BookIssueControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookIssueService bookIssueService;

	@Autowired
	private ObjectMapper objectMapper;
	
	private BookIssue bookIssue;
	
	@Test
    public void givenBookIssuedObject_whenCreateBookIssued_thenReturnSavedTransaction() throws Exception{        
		BookIssue bookIssuedTransaction = BookIssue.builder().remarks("Approved").
				transactionStatus("Transaction Approved").build();
    BDDMockito.given(bookIssueService.createBookIssue(bookIssuedTransaction, 2L, 1l, 1L)).willAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/issueBook/1/2/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(bookIssuedTransaction)));
        response.andDo(print()).
                andExpect(status().isCreated());
    }
	@Test
	public void givenBookObjectList_whenGetAllTRansactions_thenReturnTransactionList() throws Exception {
		List<BookIssue> transactionList = new ArrayList<>();
		transactionList.add(BookIssue.builder().remarks("Approved").
				transactionStatus("Transaction Approved").build());
		transactionList.add(BookIssue.builder().remarks("Rejected").
				transactionStatus("Transaction Approved").build());
		BDDMockito.given(bookIssueService.getAllTransactions()).willReturn(transactionList);
		ResultActions response = mockMvc.perform(get("/getBookTransactions"));
		response.andExpect(status().isOk());
	}
	@Test
	public void givenBookObject_whenGetTRansactionById_thenReturnBookObject() throws Exception {
		BookIssue bookIssued = BookIssue.builder().transactionId(1L).remarks("Approved").
				transactionStatus("Transaction Approved").build();
		BDDMockito.given(bookIssueService.findTransactionByTransactionId(1L)).willReturn(bookIssued);
		ResultActions response = mockMvc.perform(get("/getTransactionByTransactionId/1", bookIssued.getTransactionId()));
		response.andExpect(status().isOk()).andDo(print());
	}
	@Test
	public void givenBookObject_whenToUpdateTransaction_thenReturnBookObject() throws Exception {
		long transactionId = 4L;
		BookIssue savedBookIssue = BookIssue.builder().transactionStatus("Pending").build();
		BookIssue updateBookIssue = BookIssue.builder().bookIssueDate(new Date()).transactionStatus("Approved").remarks("Book Issued").build();
		
		BDDMockito.given(bookIssueService.findTransactionByTransactionId(savedBookIssue.getTransactionId())).willReturn(savedBookIssue);
		BDDMockito.given(bookIssueService.updateTransaction(bookIssue)).willAnswer(inv->inv.getArgument(0));
		ResultActions response = mockMvc.perform(put("/updateTransaction/{transactionId}", transactionId).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(updateBookIssue)));
		response.andDo(print());
	}
}
