package br.com.wmoddev.bookstore.dto;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.wmoddev.bookstore.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DetailBookDTO {
	
	private UUID id;
	private String title;
	private Set<String> authorsName;

	public DetailBookDTO(Book book) {
		this.id = book.getId();
		this.title = book.getTitle();
		this.authorsName = book.getAuthorBooks().stream()
				.map(ab -> ab.getAuthor().getName())
				.collect(Collectors.toSet());
	}
	
	public static List<DetailBookDTO> toListDto(List<Book> books) {
		return books.stream()
				.map(DetailBookDTO::new)
				.collect(Collectors.toList());
	}

	public static Page<DetailBookDTO> listToPage(List<DetailBookDTO> booksDto, Pageable pageable) {
		return new PageImpl<DetailBookDTO>(booksDto, pageable, booksDto.size());
	}
	
}
