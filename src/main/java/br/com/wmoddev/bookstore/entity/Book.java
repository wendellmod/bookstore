package br.com.wmoddev.bookstore.entity;

import java.io.Serializable;
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
	
    @OneToMany(mappedBy = "book")
    Set<AuthorBook> authorBooks;
	
	@Deprecated
	public Book() { super(); }
	
	@Builder
	public Book(UUID id, LocalDateTime creationDateTime, LocalDateTime modificationDateTime, String title, Set<AuthorBook> authorBooks) {
		super(id, creationDateTime, modificationDateTime);
		this.title = title;
		this.authorBooks = authorBooks;
	}

	@Override
	public int compareTo(Book o) {
		return getCreationDateTime().compareTo(o.getCreationDateTime());
	}
	
}
