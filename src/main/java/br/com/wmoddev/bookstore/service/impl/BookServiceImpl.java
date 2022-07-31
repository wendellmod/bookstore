package br.com.wmoddev.bookstore.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.wmoddev.bookstore.dto.CreateBookDTO;
import br.com.wmoddev.bookstore.dto.DetailBookDTO;
import br.com.wmoddev.bookstore.entity.Book;
import br.com.wmoddev.bookstore.repository.BookRepository;
import br.com.wmoddev.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepository bookRepository;

	public BookServiceImpl(final BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public String create(CreateBookDTO dto) {
		Book newBook = bookRepository.save(dto.build());
		return newBook.getId().toString();
	}

	@Override
	public Page<DetailBookDTO> readAll(Pageable pageable) {
		final List<Book> books = bookRepository.findAll();
		final List<DetailBookDTO> booksDto = DetailBookDTO.toListDto(books);
		return DetailBookDTO.listToPage(booksDto, pageable);
	}

}
