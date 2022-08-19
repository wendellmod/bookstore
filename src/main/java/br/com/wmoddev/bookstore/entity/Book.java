package br.com.wmoddev.bookstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @EqualsAndHashCode(callSuper=false) @ToString
@Table(name = "TB_BS_BOOK", schema = "BOOKSTORE")
public class Book extends BaseEntity implements Serializable, Comparable<Book> {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "title", nullable = false, length = 100)
	private String title;
	
	@Column(name = "subtitle", nullable = false, length = 100)
	private String subtitle;
	
	@Column(name = "price", nullable = false, scale = 2)
	private BigDecimal price;
	
	@Column(name = "isbn", nullable = false)
	private String isbn;
	
	@Column(name = "year_of_publication")
	private Integer yearOfPublication;
	
	@Column(name = "number_of_pages", nullable = false)
	private Integer numberOfPages;
	
	@Column(name = "age_rating", nullable = false)
	private String ageRating;
	
	@Column(name = "publishing_company", length = 100)
	private String publishingCompany;
	
	@Column(name = "quantity_in_stock", nullable = false)
	private Integer quantityInStock;
	
    @OneToMany(mappedBy = "book")
    Set<AuthorBook> authorBooks;
	
	@Deprecated
	public Book() { super(); }
	
	@Builder
	public Book(UUID id,
				LocalDateTime creationDateTime,
				LocalDateTime modificationDateTime,
				String title,
				String subtitle,
				BigDecimal price,
				String isbn,
				Integer yearOfPublication,
				Integer numberOfPages,
				String ageRating,
				String publishingCompany,
				Integer quantityInStock,
				Set<AuthorBook> authorBooks) {
		super(id, creationDateTime, modificationDateTime);
		this.title = title;
		this.subtitle = subtitle;
		this.price = price;
		this.isbn = isbn;
		this.yearOfPublication = yearOfPublication;
		this.numberOfPages = numberOfPages;
		this.ageRating = ageRating;
		this.publishingCompany = publishingCompany;
		this.quantityInStock = quantityInStock;
		this.authorBooks = authorBooks;
	}

	@Override
	public int compareTo(Book o) {
		return getCreationDateTime().compareTo(o.getCreationDateTime());
	}
	
}
