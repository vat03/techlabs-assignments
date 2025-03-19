package com.aurionpro.security.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class UserApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String message;
}
