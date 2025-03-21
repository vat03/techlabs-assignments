package com.aurionpro.bank.exception;

public class BankAppException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BankAppException(String message) {
		super(message);
	}
}