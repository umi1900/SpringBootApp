package org.umar.learn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CustomerException(String message) {
		super(message);
	}
	
	public CustomerException(String message, Throwable t) {
		super(message, t);
	}

}
