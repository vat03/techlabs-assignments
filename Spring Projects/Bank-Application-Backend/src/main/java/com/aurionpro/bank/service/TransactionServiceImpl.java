package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.bank.dto.PageResponse;
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

	// Get all transactions with pagination
	@Override
	public PageResponse<TransactionResponseDto> getAllTransactions(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Transaction> transactions = transactionRepo.findAll(pageable);

		List<Transaction> dbTransactions = transactions.getContent();
		List<TransactionResponseDto> transactionDtoList = new ArrayList<>();

		for (Transaction transaction : dbTransactions) {
			transactionDtoList.add(mapper.map(transaction, TransactionResponseDto.class));
		}

		return new PageResponse<>(transactions.getTotalPages(), transactions.getSize(), transactions.getTotalElements(),
				transactions.isLast(), transactionDtoList);
	}

	// Add or update transaction
	@Override
	public TransactionResponseDto addTransaction(TransactionRequestDto transactionRequestDto) {
		Transaction dbTransaction = transactionRepo.save(mapper.map(transactionRequestDto, Transaction.class));
		return mapper.map(dbTransaction, TransactionResponseDto.class);
	}

	// Delete a transaction
	@Override
	public void deleteTransaction(Transaction transaction) {
		transactionRepo.delete(transaction);
	}

	// Delete all transactions
	@Override
	public void deleteAllTransactions() {
		transactionRepo.deleteAll();
	}
}
