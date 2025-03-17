package com.aurionpro.bank.service;

import java.util.List;

import com.aurionpro.bank.dto.TransactionRequestDto;
import com.aurionpro.bank.dto.TransactionResponseDto;
import com.aurionpro.bank.entity.Transaction;

public interface TransactionService {
	List<TransactionResponseDto> getAllTransactions();

	TransactionResponseDto addTransaction(TransactionRequestDto transactionRequestDto);
	
	void deleteTransaction(Transaction transaction);
	
	void deleteAllTransactions();
}
