package com.library.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.library.model.Book;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
	@Autowired
	BookRepository bookRepository;
	
	private Book book;
	
	@BeforeEach
	public void setUpBook() {
		book = Book.builder().bookName("The Alchemist").bookAuthor("Paulo Cohelo").bookPrice(600).bookPublication("ABC").
				noOfCopies(15).numberOfPages(440).build();
	}
	@Test
	void bookExists() {
	      bookRepository.save(book);
	      Book savedBook = bookRepository.findById(book.getBookId()).get();
	      assertThat(savedBook).isNotNull();
	    }
	@Test
	public void updateBookTest() {
		bookRepository.save(book);
		Book savedBook = bookRepository.findById(book.getBookId()).get();
						savedBook.setBookName("The Alchemist");
						savedBook.setBookAuthor("Paulo Cohelo");
		Book updateBook = bookRepository.save(savedBook);
		assertThat(updateBook.getBookName()).isEqualTo("The Alchemist");
		assertThat(updateBook.getBookAuthor()).isEqualTo("Paulo Cohelo");
	}
	
	@Test
	public void deleteBookTest() {
		bookRepository.save(book);
		bookRepository.deleteById(book.getBookId());
		Optional<Book> bookDetails=bookRepository.findById(book.getBookId());
		assertThat(bookDetails).isEmpty();
	}
	
}
