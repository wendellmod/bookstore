package br.com.wmoddev.bookstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.wmoddev.bookstore.entity.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class CreateAuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Size(min = 1, max = 50)
	private String name;

	public Author build() {
		return Author.builder()
				.name(name)
				.build();
	}

}
