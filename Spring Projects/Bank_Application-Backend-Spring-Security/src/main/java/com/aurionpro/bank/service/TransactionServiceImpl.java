package com.aurionpro.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.bank.dto.PageResponse;
import com.aurionpro.bank.dto.TransactionRequestDto;
import com.aurionpro.bank.dto.TransactionResponseDto;
import com.aurionpro.bank.entity.Account;
import com.aurionpro.bank.entity.Transaction;
import com.aurionpro.bank.enums.TransactionType;
import com.aurionpro.bank.repository.AccountRepository;
import com.aurionpro.bank.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private EmailService emailService;

	private ModelMapper mapper;

	public TransactionServiceImpl() {
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

	// Add transaction with email notification
	@Override
	@Transactional
	public TransactionResponseDto addTransaction(TransactionRequestDto transactionRequestDto) {
		Optional<Account> senderAccountOpt = accountRepo.findById(transactionRequestDto.getSenderAccountId());
		if (senderAccountOpt.isEmpty()) {
			throw new RuntimeException("Sender account not found!");
		}
		Account senderAccount = senderAccountOpt.get();

		Account receiverAccount = null;
		if (transactionRequestDto.getTransactionType() == TransactionType.TRANSFER) {
			Optional<Account> receiverAccountOpt = accountRepo.findById(transactionRequestDto.getReceiverAccountId());
			if (receiverAccountOpt.isEmpty()) {
				throw new RuntimeException("Receiver account not found!");
			}
			receiverAccount = receiverAccountOpt.get();
		}

		// Perform transaction
		double amount = transactionRequestDto.getAmount();
		boolean transactionStatus = false;

		if (transactionRequestDto.getTransactionType() == TransactionType.DEPOSIT) {
			senderAccount.setBalance(senderAccount.getBalance() + amount);
			transactionStatus = true;

			// Send Email to Sender
			emailService.sendEmail(senderAccount.getCustomer().getUser().getEmail(), "Deposit Successful",
					"Rs. " + amount + " has been deposited into your account: " + senderAccount.getAccountNumber()
							+ "\nCurrent Balance: " + senderAccount.getBalance());

		} else if (transactionRequestDto.getTransactionType() == TransactionType.WITHDRAW) {
			if (senderAccount.getBalance() < amount) {
				throw new RuntimeException("Insufficient balance!");
			}
			senderAccount.setBalance(senderAccount.getBalance() - amount);
			transactionStatus = true;

			// Send Email to Sender
			emailService.sendEmail(senderAccount.getCustomer().getUser().getEmail(), "Withdrawal Successful",
					"Rs." + amount + " has been withdrawn from your account: " + senderAccount.getAccountNumber()
							+ "\nCurrent Balance: " + senderAccount.getBalance());

		} else if (transactionRequestDto.getTransactionType() == TransactionType.TRANSFER) {
			if (senderAccount.getBalance() < amount) {
				throw new RuntimeException("Insufficient balance for transfer!");
			}
			senderAccount.setBalance(senderAccount.getBalance() - amount);
			receiverAccount.setBalance(receiverAccount.getBalance() + amount);
			accountRepo.save(receiverAccount);
			transactionStatus = true;

			// Send Email to Sender
			emailService.sendEmail(senderAccount.getCustomer().getUser().getEmail(), "Funds Transfer Notification",
					"Rs. " + amount + " has been debited from your account: " + senderAccount.getAccountNumber()
							+ "\nCurrent Balance: " + senderAccount.getBalance());

			// Send Email to Receiver
			emailService.sendEmail(receiverAccount.getCustomer().getUser().getEmail(), "Funds Transfer Notification",
					"Rs. " + amount + " has been credited to your account: " + receiverAccount.getAccountNumber()
							+ "\nCurrent Balance: " + receiverAccount.getBalance());
		}

		accountRepo.save(senderAccount);

		Transaction transaction = new Transaction();
		transaction.setTransactionType(transactionRequestDto.getTransactionType());
		transaction.setAmount(amount);
		transaction.setSenderAccount(senderAccount);
		transaction.setReceiverAccount(receiverAccount);
		transaction.setStatus(transactionStatus);

		Transaction savedTransaction = transactionRepo.save(transaction);
		return mapper.map(savedTransaction, TransactionResponseDto.class);
	}

//	// Delete a transaction
//	@Override
//	public void deleteTransaction(Transaction transaction) {
//		transactionRepo.delete(transaction);
//	}
//
//	// Delete all transactions
//	@Override
//	public void deleteAllTransactions() {
//		transactionRepo.deleteAll();
//	}
}
