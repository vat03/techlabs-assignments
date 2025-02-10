package com.aurionpro.exception;

public class MinimumBalanceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public String getMessage()
	{
		return "Cannot Withdraw as Minimum balance of 500 required";
	}
}
