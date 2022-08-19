package br.com.wmoddev.bookstore.service.impl;

import static br.com.wmoddev.bookstore.util.AuthorJmsUtil.CREATE_AUTHOR;
import static br.com.wmoddev.bookstore.util.JmsUtil.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.wmoddev.bookstore.dto.CreateAuthorDTO;
import br.com.wmoddev.bookstore.dto.DetailAuthorDTO;
import br.com.wmoddev.bookstore.dto.MessageSentDTO;
import br.com.wmoddev.bookstore.entity.Author;
import br.com.wmoddev.bookstore.repository.AuthorRepository;
import br.com.wmoddev.bookstore.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private final JmsTemplate jmsTemplate;
	private final AuthorRepository authorRepository;

	public AuthorServiceImpl(final JmsTemplate jmsTemplate,
							 final AuthorRepository authorRepository) {
		this.jmsTemplate = jmsTemplate;
		this.authorRepository = authorRepository;
	}
	
	@Override
	public MessageSentDTO sentCreate(Object obj) {
		final CreateAuthorDTO dto = (CreateAuthorDTO) obj;
		return sentMessage(jmsTemplate, CREATE_AUTHOR, dto);
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
	
	@Override
	public Set<Author> getAllById(Set<UUID> ids) {
		return ids.stream()
				.map(id -> getById(id))
				.collect(Collectors.toSet());
	}
	
	private Author getById(UUID id) {
		return authorRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
