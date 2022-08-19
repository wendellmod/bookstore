package br.com.wmoddev.bookstore.service.impl;

import static br.com.wmoddev.bookstore.util.BookJmsUtil.CREATE_BOOK;
import static br.com.wmoddev.bookstore.util.JmsUtil.*;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import br.com.wmoddev.bookstore.dto.CreateBookDTO;
import br.com.wmoddev.bookstore.dto.DetailBookDTO;
import br.com.wmoddev.bookstore.dto.MessageSentDTO;
import br.com.wmoddev.bookstore.entity.Author;
import br.com.wmoddev.bookstore.entity.AuthorBook;
import br.com.wmoddev.bookstore.entity.Book;
import br.com.wmoddev.bookstore.repository.AuthorBookRepository;
import br.com.wmoddev.bookstore.repository.BookRepository;
import br.com.wmoddev.bookstore.service.AuthorService;
import br.com.wmoddev.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	private final JmsTemplate jmsTemplate;
	private final AuthorService authorService;
	private final BookRepository bookRepository;
	private final AuthorBookRepository authorBookRepository;

	public BookServiceImpl(final JmsTemplate jmsTemplate,
						   final AuthorService authorService,
						   final BookRepository bookRepository,
						   final AuthorBookRepository authorBookRepository) {
		this.jmsTemplate = jmsTemplate;
		this.authorService = authorService;
		this.bookRepository = bookRepository;
		this.authorBookRepository = authorBookRepository;
	}
	
	@Override
	public MessageSentDTO sentCreate(Object obj) {
		final CreateBookDTO dto = (CreateBookDTO) obj;
		authorService.getAllById(dto.getIdAuthors());
		return sentMessage(jmsTemplate, CREATE_BOOK, dto);
	}

	@Override
	public String create(CreateBookDTO dto) {
		final Set<Author> authors = authorService.getAllById(dto.getIdAuthors());
		final Book newBook = bookRepository.save(dto.build());
		final Set<AuthorBook> bookAuthors = dto.buildAuthorBooks(authors, newBook);
		authorBookRepository.saveAll(bookAuthors);
		
		return newBook.getId().toString();
	}

	@Override @Transactional
	public Page<DetailBookDTO> readAll(Pageable pageable) {
		final List<Book> books = bookRepository.findAll();
		final List<DetailBookDTO> booksDto = DetailBookDTO.toListDto(books);
		return DetailBookDTO.listToPage(booksDto, pageable);
	}

}
