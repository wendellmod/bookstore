package br.com.wmoddev.bookstore.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wmoddev.bookstore.dto.CreateBookDTO;
import br.com.wmoddev.bookstore.service.BookService;
import br.com.wmoddev.bookstore.util.ResponseEntityUtil;
import io.swagger.annotations.Api;

@RestController
@Api(value = "Book Controller")
@RequestMapping("books")
public class BookController {
	
	private final BookService service;

	public BookController(final BookService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid CreateBookDTO dto) {
		return ResponseEntity.created(ResponseEntityUtil.uriGenerate(service.create(dto))).body(null);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll(Pageable pageable) {
		return ResponseEntity.ok(service.readAll(pageable));
	}

}
