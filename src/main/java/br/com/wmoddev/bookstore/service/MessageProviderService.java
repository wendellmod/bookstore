package br.com.wmoddev.bookstore.service;

import br.com.wmoddev.bookstore.dto.MessageSentDTO;

public interface MessageProviderService {
	
	MessageSentDTO sentCreate(Object obj);

}
