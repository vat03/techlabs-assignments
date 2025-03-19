package com.aurionpro.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.security.dto.LoginDto;
import com.aurionpro.security.dto.RegistrationDto;
import com.aurionpro.security.entity.User;
import com.aurionpro.security.service.AuthService;

@RestController
@RequestMapping("/app")
public class SecurityController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public User register(@RequestBody RegistrationDto registration)
	{
		return authService.register(registration);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto)
	{
		return authService.login(loginDto);
	}
}
