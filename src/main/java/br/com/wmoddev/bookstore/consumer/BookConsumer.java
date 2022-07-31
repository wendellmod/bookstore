package br.com.wmoddev.bookstore.consumer;

import static br.com.wmoddev.bookstore.util.BookJmsUtil.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.wmoddev.bookstore.dto.CreateBookDTO;
import br.com.wmoddev.bookstore.service.BookService;

@Component
public class BookConsumer {
	
	private final BookService service;
	
    public BookConsumer(final BookService service) {
		this.service = service;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(BookConsumer.class);

    @JmsListener(destination = CREATE_BOOK, containerFactory = "defaultFactory")
    public void messageListener(CreateBookDTO dto) {
        LOGGER.info("Message received! {}", dto);
        
        String bookId = service.create(dto);
        
        LOGGER.info("Message processed... ", bookId);
    }

}
