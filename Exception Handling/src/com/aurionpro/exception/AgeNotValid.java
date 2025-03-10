package com.aurionpro.exception;

public class AgeNotValid extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private int age;
	
	public AgeNotValid(int age)
	{
		this.age = age;
	}

	public String getMessage()
	{
		return "Age must be greater than 18 || You entered age: "+age;
	}
}
