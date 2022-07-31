package br.com.wmoddev.bookstore.consumer;

import static br.com.wmoddev.bookstore.util.AuthorJmsUtil.CREATE_AUTHOR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.wmoddev.bookstore.dto.CreateAuthorDTO;
import br.com.wmoddev.bookstore.service.AuthorService;

@Component
public class AuthorConsumer {
	
	private final AuthorService service;
	
	public AuthorConsumer(final AuthorService service) {
		this.service = service;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorConsumer.class);

    @JmsListener(destination = CREATE_AUTHOR, containerFactory = "defaultFactory")
    public void messageListener(CreateAuthorDTO dto) {
        LOGGER.info("Message received! {}", dto);
        
        String bookId = service.create(dto);
        
        LOGGER.info("Message processed... ", bookId);
    }

}
