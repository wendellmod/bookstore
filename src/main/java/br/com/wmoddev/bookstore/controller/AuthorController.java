package br.com.wmoddev.bookstore.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wmoddev.bookstore.dto.CreateAuthorDTO;
import br.com.wmoddev.bookstore.service.AuthorService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Author Controller")
@RequestMapping("authors")
public class AuthorController {
	
	private final AuthorService service;

	public AuthorController(final AuthorService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid CreateAuthorDTO dto) {
		return ResponseEntity.ok(service.sentCreate(dto));
	}
	
	@GetMapping
	public ResponseEntity<?> readAll(Pageable pageable) {
		return ResponseEntity.ok(service.readAll(pageable));
	}

}
