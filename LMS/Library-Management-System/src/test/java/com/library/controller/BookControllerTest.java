package com.library.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.Book;
import com.library.service.BookService;
import com.library.service.UserService;

@WebMvcTest(value = BookController.class)
public class BookControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;
    
    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private Book book;
    
    @Test
    public void givenBookObject_whenInsertbook_thenReturnSavedBook() throws Exception{
        Book book = Book.builder().activeFlag(1).bookAuthor("apj kalam").bookPrice(700).bookName("Wingsoffire")
                .noOfCopies(10).bookPublication("ABC").numberOfPages(500)
                .build();
        BDDMockito.given(bookService.saveBookInfo(book)).willReturn(book);
        ResultActions response = mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(book)));
        response.andExpect(status().isCreated()).
        andDo(print());

    }
    @Test
	public void givenBookObjectList_whenGetAllUser_thenReturnBookList() throws Exception {
		List<Book> bookList = new ArrayList<>();
		bookList.add(Book.builder().bookId(1L)
                .activeFlag(1).bookAuthor("apj kalam").bookPrice(700).bookName("Wingsoffire")
                .noOfCopies(10).bookPublication("ABC").numberOfPages(500)
                .build());
		bookList.add(Book.builder().bookId(2L)
                .activeFlag(1).bookAuthor("paulo cohelo").bookPrice(650).bookName("the alchemist")
                .noOfCopies(10).bookPublication("XYZ").numberOfPages(520)
                .build());
		BDDMockito.given(bookService.getAllBooks()).willReturn(bookList);
		ResultActions response = mockMvc.perform(get("/getAllBook"));
		response.andExpect(status().isOk());
	}
    @Test
	public void givenBookObject_whenGetbyName_thenReturnBookObject() throws Exception {
		 Book book = Book.builder().activeFlag(1).bookAuthor("paulo cohelo").bookPrice(650).bookName("the alchemist")
	                .noOfCopies(10).bookPublication("XYZ").numberOfPages(520).build();
		BDDMockito.given(bookService.searchByName("the alchemist")).willReturn(List.of(book));
		ResultActions response = mockMvc.perform(get("/searchBookByName/the alchemist", book.getBookName()));
		response.andExpect(status().isOk());
		
	}
    @Test
	public void givenBookObject_ToDeleteBookData_thenReturnBookObject() throws Exception {
		 Book book = Book.builder().bookId(1L)
	                .activeFlag(1).bookAuthor("paulo cohelo").bookPrice(650).bookName("the alchemist")
	                .noOfCopies(10).bookPublication("XYZ").numberOfPages(520).build();
		BDDMockito.given(bookService.deleteBook(book.getBookName(),1L)).willReturn(book);
		ResultActions response = mockMvc.perform(delete("/deleteBookByName/Fear of Flying/1", book.getBookId()));
		response.andExpect(status().isOk()).andDo(print());	
	}
	
  
}
