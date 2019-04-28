package com.chocksaway.exception;

/**
 * Author milesd on 27/04/2019.
 */
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1791224631238215443L;

	public BadRequestException(String message) {
		super(message);
	}

}
