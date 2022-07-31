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
@Table(name = "TB_BS_AUTHOR", schema = "BOOKSTORE")
public class Author extends BaseEntity implements Serializable, Comparable<Author> {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
    @OneToMany(mappedBy = "author")
    Set<AuthorBook> booksAuthor;
	
	@Deprecated
	public Author() { super(); }
	
	@Builder
	public Author(UUID id, LocalDateTime creationDateTime, LocalDateTime modificationDateTime, String name, Set<AuthorBook> booksAuthor) {
		super(id, creationDateTime, modificationDateTime);
		this.name = name;
		this.booksAuthor = booksAuthor;
	}
	
	@Override
	public int compareTo(Author o) {
		return getCreationDateTime().compareTo(o.getCreationDateTime());
	}

}
