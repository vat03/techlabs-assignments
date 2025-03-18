//package com.aurionpro.bank.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.aurionpro.bank.dto.AdminRequestDto;
//import com.aurionpro.bank.dto.AdminResponseDto;
//import com.aurionpro.bank.dto.PageResponse;
//import com.aurionpro.bank.service.AdminService;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/bankapp/admin")
//public class AdminController {
//
//	@Autowired
//	private AdminService adminService;
//
//	@GetMapping("/getAllAdmins")
//	public ResponseEntity<PageResponse<AdminResponseDto>> getAllAdmins(@RequestParam int pageNumber,
//			@RequestParam int pageSize) {
//		return ResponseEntity.ok(adminService.getAllAdmins(pageNumber, pageSize));
//	}
//
//	@PostMapping("/addAdmin")
//	public ResponseEntity<AdminResponseDto> addAdmin(@Valid @RequestBody AdminRequestDto adminRequestDto) {
//		return ResponseEntity.ok(adminService.addAdmin(adminRequestDto));
//	}
//
//	@PutMapping("/updateAdmin")
//	public ResponseEntity<AdminResponseDto> updateAdmin(@Valid @RequestBody AdminRequestDto adminRequestDto) {
//		return ResponseEntity.ok(adminService.addAdmin(adminRequestDto));
//	}
//
//	@DeleteMapping("/deleteAdmin/{adminId}")
//	public void deleteAdmin(@PathVariable int adminId) {
//		adminService.deleteAdmin(adminId);
//	}
//
//	@DeleteMapping("/deleteAllAdmins")
//	public void deleteAllAdmins() {
//		adminService.deleteAllAdmins();
//	}
//}

package com.aurionpro.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bank.dto.AdminRequestDto;
import com.aurionpro.bank.dto.AdminResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankapp/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// Get all admins with pagination
	@GetMapping("/getAllAdmins")
	public ResponseEntity<PageResponse<AdminResponseDto>> getAllAdmins(@RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return ResponseEntity.ok(adminService.getAllAdmins(pageNumber, pageSize));
	}

	// Add new admin
//	@PostMapping("/addAdmin")
//	public ResponseEntity<AdminResponseDto> addAdmin(@PathVariable int adminId, @Valid @RequestBody AdminRequestDto adminRequestDto) {
//		return ResponseEntity.ok(adminService.addAdmin(adminRequestDto));
//	}

	// Update existing admin details (without modifying userId)
	@PutMapping("/updateAdmin/{adminId}")
	public ResponseEntity<AdminResponseDto> updateAdmin(@PathVariable int adminId,
			@Valid @RequestBody AdminRequestDto adminRequestDto) {
		return ResponseEntity.ok(adminService.updateAdmin(adminId, adminRequestDto));
	}

	// Soft delete admin by ID
	@DeleteMapping("/deleteAdmin/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable int adminId) {
		adminService.deleteAdmin(adminId);
		return ResponseEntity.ok("Admin soft deleted successfully!");
	}

	// Soft delete all admins
//	@DeleteMapping("/deleteAllAdmins")
//	public ResponseEntity<String> deleteAllAdmins() {
//		adminService.deleteAllAdmins();
//		return ResponseEntity.ok("All admins soft deleted successfully!");
//	}
}
