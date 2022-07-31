package br.com.wmoddev.bookstore.controller;

import static br.com.wmoddev.bookstore.util.BookJmsUtil.*;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wmoddev.bookstore.dto.CreateBookDTO;
import br.com.wmoddev.bookstore.dto.MessageSentDTO;
import br.com.wmoddev.bookstore.service.BookService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Book Controller")
@RequestMapping("books")
public class BookController {
	
	private final JmsTemplate jmsTemplate;
	private final BookService service;
	
	public BookController(final JmsTemplate jmsTemplate,
						  final BookService service) {
		this.jmsTemplate = jmsTemplate;
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid CreateBookDTO dto) {
		try {
			jmsTemplate.convertAndSend(CREATE_BOOK, dto);
            return new ResponseEntity<>(new MessageSentDTO("Sent."), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@GetMapping
	public ResponseEntity<?> readAll(Pageable pageable) {
		return ResponseEntity.ok(service.readAll(pageable));
	}

}
