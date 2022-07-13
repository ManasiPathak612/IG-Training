package com.library.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.library.model.Book;
import com.library.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;
	
	private Book book;
	
	@BeforeEach
	public void setUpBook() {
		book = Book.builder().bookName("The Alchemist").bookAuthor("Paulo Cohelo").bookPrice(600).bookPublication("ABC").
				noOfCopies(15).numberOfPages(440).bookId(2).build();
	}
	
	@Test
    public void BookObject_whenSaveBook_thenReturnBookObject(){
		BDDMockito.given(bookRepository.save(book)).willReturn(book);
 		Book savedBook = bookService.saveBook(book);
 		assertThat(savedBook).isNotNull();
    }
	@Test
    public void givenUserList_whenGetAllBook_thenReturnBookList(){
		BDDMockito.given(bookRepository.findAll()).willReturn(List.of(book,book));
        List<Book> BookList = bookService.getAllBooks();
        assertThat(BookList).isNotNull();
        assertThat(BookList.size()).isGreaterThan(0);
    }
	@Test
	public void givenBookObject_whenDeleteById_thenReturnNothing() {
		BDDMockito.willDoNothing().given(bookRepository).deleteById(book.getBookId());
		bookService.deleteBook(book.getBookName(),book.getBookId());
		verify(bookRepository, times(1)).deleteById(book.getBookId());
		
	}
}
