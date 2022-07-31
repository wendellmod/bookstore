package br.com.wmoddev.bookstore.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.wmoddev.bookstore.dto.CreateAuthorDTO;
import br.com.wmoddev.bookstore.dto.DetailAuthorDTO;
import br.com.wmoddev.bookstore.entity.Author;
import br.com.wmoddev.bookstore.repository.AuthorRepository;
import br.com.wmoddev.bookstore.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private final AuthorRepository authorRepository;

	public AuthorServiceImpl(final AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public String create(CreateAuthorDTO dto) {
		final Author newAuthor = authorRepository.save(dto.build());
		return newAuthor.getId().toString();
	}

	@Override
	public Page<DetailAuthorDTO> readAll(Pageable pageable) {
		List<Author> authors = authorRepository.findAll();
		List<DetailAuthorDTO> authorsDto = DetailAuthorDTO.toListDto(authors);
		return DetailAuthorDTO.listToPage(authorsDto, pageable);
	}

}
