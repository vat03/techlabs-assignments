package com.aurionpro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.spring.entity.Computer;

@RestController
@RequestMapping("/app")
public class SayHelloController {
	
	@Autowired
	private Computer computer;

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello, Welcome to Rest API";
	}

	@GetMapping("/sayBye")
	public String sayBye() {
		return "Good Bye from Rest API";
	}
	
	@GetMapping("/computers")
	public String comp()
	{
		return computer.toString();
	}
}
