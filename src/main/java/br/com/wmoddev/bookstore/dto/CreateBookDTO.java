package br.com.wmoddev.bookstore.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

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
	
	@NotBlank
	@Size(min = 1, max = 100)
	private String subtitle;
	
	@NotNull
	private BigDecimal price;
	
	@ISBN
	@NotBlank
	private String isbn;
	
	@NotNull
	private Integer yearOfPublication;
	
	@NotNull
	private Integer numberOfPages;
	
	@NotBlank
	private String ageRating;
	
	@NotBlank
	private String publishingCompany;
	
	@NotNull
	private Integer quantityInStock;
	
	@NotNull
	private Set<UUID> idAuthors;
	
	public Book build() {
		return Book.builder()
				.title(title)
				.subtitle(subtitle)
				.price(price)
				.isbn(isbn)
				.yearOfPublication(yearOfPublication)
				.numberOfPages(numberOfPages)
				.ageRating(ageRating)
				.publishingCompany(publishingCompany)
				.quantityInStock(quantityInStock)
				.build();
	}
	
	public Set<AuthorBook> buildAuthorBooks(Set<Author> authors, Book book) {
		return authors.stream()
				.map(a -> buildAuthorBook(a, book))
				.collect(Collectors.toSet());
	}
	
	private AuthorBook buildAuthorBook(Author author, Book book) {
		return AuthorBook.builder()
				.id(new AuthorBookKey(author.getId(), book.getId()))
				.author(author)
				.book(book)
				.build();
	}

}
