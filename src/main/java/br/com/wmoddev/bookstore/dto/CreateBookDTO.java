package br.com.wmoddev.bookstore.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.wmoddev.bookstore.entity.Author;
import br.com.wmoddev.bookstore.entity.AuthorBook;
import br.com.wmoddev.bookstore.entity.AuthorBookKey;
import br.com.wmoddev.bookstore.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class CreateBookDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Size(min = 1, max = 100)
	private String title;
	
	@NotNull
	private List<UUID> idAuthors;
	
	public Book build() {
		return Book.builder()
				.title(title)
				.build();
	}
	
	public List<AuthorBook> buildAuthorBooks(List<Author> authors, Book book) {
		return authors.stream()
				.map(a -> buildAuthorBook(a, book))
				.collect(Collectors.toList());
	}
	
	private AuthorBook buildAuthorBook(Author author, Book book) {
		return AuthorBook.builder()
				.id(new AuthorBookKey(author.getId(), book.getId()))
				.author(author)
				.book(book)
				.build();
	}

}
