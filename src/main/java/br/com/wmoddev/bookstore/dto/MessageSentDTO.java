package br.com.wmoddev.bookstore.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class MessageSentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String message;

}
