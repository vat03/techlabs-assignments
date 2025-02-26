package com.aurionpro.exceptions;


public class InsufficientStockException extends Exception {
	private static final long serialVersionUID = 1L;

	public InsufficientStockException(String message) {
        super(message);
    }
}
