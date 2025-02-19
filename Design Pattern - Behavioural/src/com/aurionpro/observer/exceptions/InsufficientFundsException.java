package com.aurionpro.observer.exceptions;

public class InsufficientFundsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "Insufficient balance";
	}
}