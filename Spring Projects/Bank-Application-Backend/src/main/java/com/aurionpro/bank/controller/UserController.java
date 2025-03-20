package com.aurionpro.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.aurionpro.bank.dto.UserUpdateRequestDto;
import com.aurionpro.bank.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankapp/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<PageResponse<UserResponseDto>> getAllUsers(@RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return ResponseEntity.ok(userService.getAllUsers(pageNumber, pageSize));
	}

	@PostMapping("/users")
	public ResponseEntity<UserResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto) {
		return ResponseEntity.ok(userService.addUser(userRequestDto));
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<UserResponseDto> updateUser(@PathVariable int userId,
			@Valid @RequestBody UserUpdateRequestDto userUpdateRequestDto) {
		return ResponseEntity.ok(userService.updateUser(userId, userUpdateRequestDto));
	}

	@PutMapping("/DeactivateUser/{userId}")
	public ResponseEntity<String> deactivateUser(@PathVariable int userId) {
		userService.deactivateUser(userId);
		return ResponseEntity.ok("User deactivated successfully.");
	}

//	@DeleteMapping("/deleteAllUsers")
//	public ResponseEntity<String> deleteAllUsers() {
//		userService.deleteAllUsers();
//		return ResponseEntity.ok("All users have been deleted.");
//	}
}