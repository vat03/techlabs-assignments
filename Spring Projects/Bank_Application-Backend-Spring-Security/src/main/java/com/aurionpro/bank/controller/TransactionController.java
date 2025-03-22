package com.aurionpro.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.dto.TransactionRequestDto;
import com.aurionpro.bank.dto.TransactionResponseDto;

import com.aurionpro.bank.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankappsecurity/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transactions")
	public ResponseEntity<PageResponse<TransactionResponseDto>> getAllTransactions(@RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return ResponseEntity.ok(transactionService.getAllTransactions(pageNumber, pageSize));
	}

	@PostMapping("/transactions")
	public ResponseEntity<TransactionResponseDto> addTransaction(
			@Valid @RequestBody TransactionRequestDto transactionRequestDto) {
		return ResponseEntity.ok(transactionService.addTransaction(transactionRequestDto));
	}

//	@PutMapping("/updateTransaction")
//	public ResponseEntity<TransactionResponseDto> updateTransaction(
//			@Valid @RequestBody TransactionRequestDto transactionRequestDto) {
//		return ResponseEntity.ok(transactionService.addTransaction(transactionRequestDto));
//	}
//
//	@DeleteMapping("/deleteTransaction")
//	public void deleteTransaction(@RequestBody Transaction transaction) {
//		transactionService.deleteTransaction(transaction);
//	}
//
//	@DeleteMapping("/deleteAllTransactions")
//	public void deleteAllTransactions() {
//		transactionService.deleteAllTransactions();
//	}
}
