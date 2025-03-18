package com.aurionpro.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bank.dto.AccountRequestDto;
import com.aurionpro.bank.dto.AccountResponseDto;
import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.entity.Account;
import com.aurionpro.bank.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankapp/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/getAllAccounts")
	public ResponseEntity<PageResponse<AccountResponseDto>> getAllAccounts(@RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return ResponseEntity.ok(accountService.getAllAccounts(pageNumber, pageSize));
	}

	@PostMapping("/addAccount")
	public ResponseEntity<AccountResponseDto> addAccount(@Valid @RequestBody AccountRequestDto accountRequestDto) {
		return ResponseEntity.ok(accountService.addAccount(accountRequestDto));
	}

	@PutMapping("/updateAccount")
	public ResponseEntity<AccountResponseDto> updateAccount(@Valid @RequestBody AccountRequestDto accountRequestDto) {
		return ResponseEntity.ok(accountService.addAccount(accountRequestDto));
	}

	@DeleteMapping("/deleteAccount")
	public void deleteAccount(@RequestBody Account account) {
		accountService.deleteAccount(account);
	}

	@DeleteMapping("/deleteAllAccounts")
	public void deleteAllAccounts() {
		accountService.deleteAllAccounts();
	}
}
