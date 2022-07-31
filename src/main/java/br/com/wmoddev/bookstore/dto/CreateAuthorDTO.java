package br.com.wmoddev.bookstore.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.wmoddev.bookstore.entity.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CreateAuthorDTO {
	
	@NotBlank
	@Size(min = 1, max = 50)
	private String name;

	public Author build() {
		return Author.builder()
				.name(name)
				.build();
	}

}
