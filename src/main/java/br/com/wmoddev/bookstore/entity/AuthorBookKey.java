package br.com.wmoddev.bookstore.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class AuthorBookKey implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "author_id")
	private UUID authorId;
	
	@Column(name = "book_id")
	private UUID bookId;

}
