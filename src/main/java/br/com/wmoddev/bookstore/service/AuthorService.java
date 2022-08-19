package br.com.wmoddev.bookstore.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.wmoddev.bookstore.dto.CreateAuthorDTO;
import br.com.wmoddev.bookstore.dto.DetailAuthorDTO;
import br.com.wmoddev.bookstore.entity.Author;

public interface AuthorService extends MessageProviderService {

	String create(CreateAuthorDTO dto);

	Page<DetailAuthorDTO> readAll(Pageable pageable);

	Set<Author> getAllById(Set<UUID> idAuthors);

}
