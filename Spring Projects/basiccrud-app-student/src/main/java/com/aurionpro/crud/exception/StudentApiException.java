package com.aurionpro.crud.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentApiException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public StudentApiException(String message) {
		super();
		this.message = message;
	}

	public StudentApiException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "StudentApiException [message=" + message + "]";
	}

	public String getMesage()
	{
		return message;
	}
}
