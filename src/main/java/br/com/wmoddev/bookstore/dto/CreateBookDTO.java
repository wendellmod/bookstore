package br.com.wmoddev.bookstore.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.wmoddev.bookstore.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CreateBookDTO {
	
	@NotBlank
	@Size(min = 1, max = 100)
	private String title;
	
	public Book build() {
		return Book.builder()
				.title(title)
				.build();
	}

}
