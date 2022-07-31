package br.com.wmoddev.bookstore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.wmoddev.bookstore.dto.CreateAuthorDTO;
import br.com.wmoddev.bookstore.dto.DetailAuthorDTO;

public interface AuthorService {

	String create(CreateAuthorDTO dto);

	Page<DetailAuthorDTO> readAll(Pageable pageable);

}
