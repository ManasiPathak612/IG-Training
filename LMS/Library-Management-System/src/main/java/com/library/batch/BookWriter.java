package com.library.batch;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.library.model.Book;
import com.library.repository.BookRepository;

@Configuration
public class BookWriter implements ItemWriter<Book>{
	@Autowired
	private BookRepository bookRepository;

	private static final Logger log = LoggerFactory.getLogger(BookWriter.class);
	
	@Override
	public void write(List<? extends Book> books) throws Exception {
		log.info("Data saved for :"+books);
		bookRepository.saveAll(books);
	}
}
