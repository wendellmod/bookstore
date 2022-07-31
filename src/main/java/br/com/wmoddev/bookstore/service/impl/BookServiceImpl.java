package br.com.wmoddev.bookstore.service.impl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.wmoddev.bookstore.dto.CreateBookDTO;
import br.com.wmoddev.bookstore.dto.DetailBookDTO;
import br.com.wmoddev.bookstore.entity.Author;
import br.com.wmoddev.bookstore.entity.AuthorBook;
import br.com.wmoddev.bookstore.entity.Book;
import br.com.wmoddev.bookstore.repository.AuthorBookRepository;
import br.com.wmoddev.bookstore.repository.AuthorRepository;
import br.com.wmoddev.bookstore.repository.BookRepository;
import br.com.wmoddev.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final AuthorBookRepository authorBookRepository;

	public BookServiceImpl(final AuthorRepository authorRepository,
						   final BookRepository bookRepository,
						   final AuthorBookRepository authorBookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.authorBookRepository = authorBookRepository;
	}

	@Override
	public String create(CreateBookDTO dto) {
		final List<Author> authors = getAllById(dto.getIdAuthors());
		final Book newBook = bookRepository.save(dto.build());
		final List<AuthorBook> bookAuthors = dto.buildAuthorBooks(authors, newBook);
		authorBookRepository.saveAll(bookAuthors);
		
		return newBook.getId().toString();
	}

	@Override @Transactional
	public Page<DetailBookDTO> readAll(Pageable pageable) {
		final List<Book> books = bookRepository.findAll();
		final List<DetailBookDTO> booksDto = DetailBookDTO.toListDto(books);
		return DetailBookDTO.listToPage(booksDto, pageable);
	}
	
	private List<Author> getAllById(List<UUID> ids) {
		return authorRepository.findAllById(ids);
	}

}
