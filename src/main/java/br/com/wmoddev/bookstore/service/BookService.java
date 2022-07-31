package br.com.wmoddev.bookstore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.wmoddev.bookstore.dto.CreateBookDTO;
import br.com.wmoddev.bookstore.dto.DetailBookDTO;

public interface BookService {

	String create(CreateBookDTO dto);

	Page<DetailBookDTO> readAll(Pageable pageable);

}
