package br.com.wmoddev.bookstore.controller;

import static br.com.wmoddev.bookstore.util.AuthorJmsUtil.CREATE_AUTHOR;

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

import br.com.wmoddev.bookstore.dto.CreateAuthorDTO;
import br.com.wmoddev.bookstore.dto.MessageSentDTO;
import br.com.wmoddev.bookstore.service.AuthorService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Author Controller")
@RequestMapping("authors")
public class AuthorController {
	
	private final JmsTemplate jmsTemplate;
	private final AuthorService service;

	public AuthorController(final JmsTemplate jmsTemplate,final AuthorService service) {
		this.jmsTemplate = jmsTemplate;
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid CreateAuthorDTO dto) {
		try {
			jmsTemplate.convertAndSend(CREATE_AUTHOR, dto);
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
