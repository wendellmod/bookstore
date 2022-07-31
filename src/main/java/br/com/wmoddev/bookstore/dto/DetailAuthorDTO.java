package br.com.wmoddev.bookstore.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.wmoddev.bookstore.entity.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DetailAuthorDTO {
	
	private UUID id;
	private String name;
	
	public DetailAuthorDTO(Author author) {
		this.id = author.getId();
		this.name = author.getName();
	}

	public static List<DetailAuthorDTO> toListDto(List<Author> authors) {
		return authors.stream()
				.map(DetailAuthorDTO::new)
				.collect(Collectors.toList());
	}

	public static Page<DetailAuthorDTO> listToPage(List<DetailAuthorDTO> authorsDto, Pageable pageable) {
		return new PageImpl<DetailAuthorDTO>(authorsDto, pageable, authorsDto.size());
	}

}
