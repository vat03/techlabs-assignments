package com.aurionpro.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;
import com.aurionpro.bank.entity.User;
import com.aurionpro.bank.service.UserService;

@RestController
@RequestMapping("/bankapp/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserResponseDto>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@PostMapping("/addUser")
	public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto) {
		return ResponseEntity.ok(userService.addUser(userRequestDto));
	}

	@PutMapping("/updateUser")
	public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto userRequestDto) {
		return ResponseEntity.ok(userService.addUser(userRequestDto));
	}

	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
	}
	
	@DeleteMapping("/deleteAllUsers")
	public void deleteAllUsers()
	{
		userService.deleteAllUsers();
	}
}