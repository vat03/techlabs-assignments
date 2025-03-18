package com.aurionpro.bank.service;

import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.dto.TransactionRequestDto;
import com.aurionpro.bank.dto.TransactionResponseDto;
import com.aurionpro.bank.entity.Transaction;

public interface TransactionService {
	PageResponse<TransactionResponseDto> getAllTransactions(int pageNumber, int pageSize);

	TransactionResponseDto addTransaction(TransactionRequestDto transactionRequestDto);

	void deleteTransaction(Transaction transaction);

	void deleteAllTransactions();
}
