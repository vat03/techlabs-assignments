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

import com.aurionpro.bank.dto.AdminRequestDto;
import com.aurionpro.bank.dto.AdminResponseDto;
import com.aurionpro.bank.entity.Admin;
import com.aurionpro.bank.service.AdminService;

@RestController
@RequestMapping("/bankapp/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/getAllAdmins")
	public ResponseEntity<List<AdminResponseDto>> getAllAdmins() {
		return ResponseEntity.ok(adminService.getAllAdmins());
	}

	@PostMapping("/addAdmin")
	public ResponseEntity<AdminResponseDto> addAdmin(@RequestBody AdminRequestDto adminRequestDto) {
		return ResponseEntity.ok(adminService.addAdmin(adminRequestDto));
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<AdminResponseDto> updateAdmin(@RequestBody AdminRequestDto adminRequestDto) {
		return ResponseEntity.ok(adminService.addAdmin(adminRequestDto));
	}

	@DeleteMapping("/deleteAdmin")
	public void deleteAdmin(@RequestBody Admin admin) {
		adminService.deleteAdmin(admin);
	}

	@DeleteMapping("/deleteAllAdmins")
	public void deleteAllAdmins() {
		adminService.deleteAllAdmins();
	}
}
