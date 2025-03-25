package com.aurionpro.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aurionpro.bank.dto.AccountRequestDto;
import com.aurionpro.bank.dto.AccountResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankappsecurity/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	// Get all accounts with pagination
	@GetMapping("/accounts")
	public ResponseEntity<PageResponse<AccountResponseDto>> getAllAccounts(@RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return ResponseEntity.ok(accountService.getAllAccounts(pageNumber, pageSize));
	}

	// Add account
	@PostMapping("/accounts")
	public ResponseEntity<AccountResponseDto> addAccount(@Valid @RequestBody AccountRequestDto accountRequestDto) {
		return ResponseEntity.ok(accountService.addAccount(accountRequestDto));
	}

	// Update account
	@PutMapping("/accounts/{accountId}")
	public ResponseEntity<AccountResponseDto> updateAccount(@PathVariable int accountId,
			@Valid @RequestBody AccountRequestDto accountRequestDto) {
		return ResponseEntity.ok(accountService.updateAccount(accountId, accountRequestDto));
	}

	// Delete a specific account (soft delete)
	@PutMapping("/deactivate/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable int accountId) {
		accountService.deleteAccount(accountId);
		return ResponseEntity.ok("Account with ID " + accountId + " has been deactivated.");
	}

	// Delete all accounts (use carefully)
//	@DeleteMapping("/deleteAllAccounts")
//	public ResponseEntity<String> deleteAllAccounts() {
//		accountService.deleteAllAccounts();
//		return ResponseEntity.ok("All accounts have been deleted.");
//	}
}
