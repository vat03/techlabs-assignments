package com.aurionpro.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.dto.UserRequestDto;
import com.aurionpro.bank.dto.UserResponseDto;
import com.aurionpro.bank.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankapp/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<PageResponse<UserResponseDto>> getAllUsers(@RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return ResponseEntity.ok(userService.getAllUsers(pageNumber, pageSize));
	}

	@PostMapping("/addUser")
	public ResponseEntity<UserResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto) {
		return ResponseEntity.ok(userService.addUser(userRequestDto));
	}

	@PutMapping("/updateUser")
	public ResponseEntity<UserResponseDto> updateUser(@Valid @RequestBody UserRequestDto userRequestDto) {
		return ResponseEntity.ok(userService.addUser(userRequestDto));
	}

	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
	}

	@DeleteMapping("/deleteAllUsers")
	public void deleteAllUsers() {
		userService.deleteAllUsers();
	}
}
