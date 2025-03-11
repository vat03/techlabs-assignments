package com.aurionpro.crud.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aurionpro.crud.error.studentErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<studentErrorMessage> handleStudentApiException(StudentApiException e) {
		studentErrorMessage errorMessage = new studentErrorMessage();
		errorMessage.setMessage(e.getMessage());
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		errorMessage.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<studentErrorMessage>(errorMessage ,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> handleStudentApiException(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<>();
		
		e.getBindingResult().getFieldErrors().forEach((error) -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
//		studentErrorMessage errorMessage = new studentErrorMessage();
//		errorMessage.setMessage(e.getMessage());
//		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
//		errorMessage.setTime(System.currentTimeMillis());
	
		return new ResponseEntity<>(errors ,HttpStatus.NOT_FOUND);
	}
}