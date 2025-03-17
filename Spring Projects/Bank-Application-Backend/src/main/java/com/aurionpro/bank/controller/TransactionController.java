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

import com.aurionpro.bank.dto.TransactionRequestDto;
import com.aurionpro.bank.dto.TransactionResponseDto;
import com.aurionpro.bank.entity.Transaction;
import com.aurionpro.bank.service.TransactionService;

@RestController
@RequestMapping("/bankapp/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/getAllTransactions")
	public ResponseEntity<List<TransactionResponseDto>> getAllTransactions() {
		return ResponseEntity.ok(transactionService.getAllTransactions());
	}

	@PostMapping("/addTransaction")
	public ResponseEntity<TransactionResponseDto> addTransaction(
			@RequestBody TransactionRequestDto transactionRequestDto) {
		return ResponseEntity.ok(transactionService.addTransaction(transactionRequestDto));
	}

	@PutMapping("/updateTransaction")
	public ResponseEntity<TransactionResponseDto> updateTransaction(
			@RequestBody TransactionRequestDto transactionRequestDto) {
		return ResponseEntity.ok(transactionService.addTransaction(transactionRequestDto));
	}

	@DeleteMapping("/deleteTransaction")
	public void deleteTransaction(@RequestBody Transaction transaction) {
		transactionService.deleteTransaction(transaction);
	}

	@DeleteMapping("/deleteAllTransactions")
	public void deleteAllTransactions() {
		transactionService.deleteAllTransactions();
	}
}
