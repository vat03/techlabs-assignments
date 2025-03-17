package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.TransactionRequestDto;
import com.aurionpro.bank.dto.TransactionResponseDto;
import com.aurionpro.bank.entity.Transaction;
import com.aurionpro.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;

	private ModelMapper mapper;

	private TransactionServiceImpl() {
		this.mapper = new ModelMapper();
	}

	// Get all transactions
	@Override
	public List<TransactionResponseDto> getAllTransactions() {
		List<Transaction> transactions = transactionRepo.findAll();
		List<TransactionResponseDto> transactionDto = new ArrayList<>();
		for (Transaction transaction : transactions) {
			transactionDto.add(mapper.map(transaction, TransactionResponseDto.class));
		}
		
		return transactionDto;
	}

	// add / update transaction
	@Override
	public TransactionResponseDto addTransaction(TransactionRequestDto transactionRequestDto) {
		Transaction dbTransaction = transactionRepo.save(mapper.map(transactionRequestDto, Transaction.class));
		return mapper.map(dbTransaction, TransactionResponseDto.class);
	}

	// delete a transaction
	@Override
	public void deleteTransaction(Transaction transaction) {
		transactionRepo.delete(transaction);
	}

	// delete all transactions
	@Override
	public void deleteAllTransactions() {
		transactionRepo.deleteAll();
	}

}
