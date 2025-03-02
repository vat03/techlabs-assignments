package com.aurionpro.exceptions;

public class AccountNumberNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountNumberNotFoundException(String message) {
		super(message);
	}
}
