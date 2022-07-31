package br.com.wmoddev.bookstore.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor @ToString
@Table(name = "TB_BS_AUTHOR_BOOK", schema = "BOOKSTORE")
public class AuthorBook {
	
	@EmbeddedId
	private AuthorBookKey id;
	
    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(name = "author_id")
    private Author author;
    
    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;
    
    @Builder
	public AuthorBook(AuthorBookKey id, Author author, Book book) {
		this.id = id;
		this.author = author;
		this.book = book;
	}

}
