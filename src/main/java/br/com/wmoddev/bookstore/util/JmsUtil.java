package br.com.wmoddev.bookstore.util;

import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.wmoddev.bookstore.dto.MessageSentDTO;

@Component
public class JmsUtil {
	
	public static MessageSentDTO sentMessage(final JmsTemplate jmsTemplate,
											 final String destinationName,
											 final Object obj) {
		try {
			jmsTemplate.convertAndSend(destinationName, obj);
	        return new MessageSentDTO("Sent.");
	    } catch (Exception e) {
	        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
