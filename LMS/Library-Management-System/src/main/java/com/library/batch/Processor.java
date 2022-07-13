package com.library.batch;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.library.model.Book;
import com.library.model.User;
import com.library.repository.BookRepository;

@Component
public class Processor implements ItemProcessor<Book, Book> {
	private User user;
	public static final Logger log =  LoggerFactory.getLogger(ItemProcessor.class);
	
	@Override
	public Book process(Book books) throws Exception {
		log.info("Book Process start");
		books.setModifiedOn(new Date());
		books.setCreatedOn(new Date());
		books.setActiveFlag(1);
		log.info("--------------------"+books);
		log.info("Book Process stop");
		return books;
	}
}
