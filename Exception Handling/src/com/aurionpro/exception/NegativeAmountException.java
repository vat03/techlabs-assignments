package com.aurionpro.exception;

public class NegativeAmountException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private double amount;
	
	public NegativeAmountException(double amount)
	{
		this.amount = amount;
	}
	
	public String getMessage()
	{
		return "Negative amount not accepted !! Enter a valid amount || You entered: "+amount;
	}
}
