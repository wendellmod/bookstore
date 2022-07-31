package br.com.wmoddev.bookstore.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter @EqualsAndHashCode(callSuper=false) @ToString
@Table(name = "TB_BS_BOOK", schema = "BOOKSTORE")
public class Book extends BaseEntity implements Serializable, Comparable<Book> {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "title", nullable = false, length = 100)
	private String title;
	
	@Deprecated
	public Book() { super(); }
	
	@Builder
	public Book(UUID id, LocalDateTime creationDateTime, LocalDateTime modificationDateTime, String title) {
		super(id, creationDateTime, modificationDateTime);
		this.title = title;
	}

	@Override
	public int compareTo(Book o) {
		return getCreationDateTime().compareTo(o.getCreationDateTime());
	}
	
}
