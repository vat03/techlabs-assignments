package com.aurionpro.repository;

import com.aurionpro.db.DatabaseConnection;
import com.aurionpro.entity.AccountEntity;
import com.aurionpro.entity.TransactionEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
	public void addTransaction(TransactionEntity transaction) {
		String sql = "INSERT INTO Transactions (sender_account_id, receiver_account_id, transaction_type, amount) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, transaction.getSenderAccountId());
			stmt.setInt(2, transaction.getReceiverAccountId());
			stmt.setString(3, transaction.getTransactionType());
			stmt.setDouble(4, transaction.getAmount());
			stmt.executeUpdate();

			AccountRepository accountRepo = new AccountRepository();
			AccountEntity senderAccount = accountRepo.getAccountById(transaction.getSenderAccountId());
			AccountEntity receiverAccount = accountRepo.getAccountById(transaction.getReceiverAccountId());

			if ("debit".equals(transaction.getTransactionType())
					|| "transfer".equals(transaction.getTransactionType())) {
				double newSenderBalance = senderAccount.getBalance() - transaction.getAmount();
				accountRepo.updateBalance(senderAccount.getAccountId(), newSenderBalance);
			}
			if ("credit".equals(transaction.getTransactionType())
					|| "transfer".equals(transaction.getTransactionType())) {
				double newReceiverBalance = receiverAccount.getBalance() + transaction.getAmount();
				accountRepo.updateBalance(receiverAccount.getAccountId(), newReceiverBalance);
			}

			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<TransactionEntity> getAllTransactions() {
		List<TransactionEntity> transactions = new ArrayList<>();
		String sql = "SELECT * FROM Transactions";
		try (Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				TransactionEntity transaction = new TransactionEntity();
				transaction.setTransactionId(rs.getInt("transaction_id"));
				transaction.setSenderAccountId(rs.getInt("sender_account_id"));
				transaction.setReceiverAccountId(rs.getInt("receiver_account_id"));
				transaction.setTransactionType(rs.getString("transaction_type"));
				transaction.setAmount(rs.getDouble("amount"));
				transaction.setTransactionDate(rs.getTimestamp("transaction_date"));
				transaction.setStatus(rs.getString("status"));
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

	public List<TransactionEntity> getTransactionsByAccountId(int accountId) {
		List<TransactionEntity> transactions = new ArrayList<>();
		String sql = "SELECT * FROM Transactions WHERE sender_account_id = ? OR receiver_account_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, accountId);
			stmt.setInt(2, accountId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TransactionEntity transaction = new TransactionEntity();
				transaction.setTransactionId(rs.getInt("transaction_id"));
				transaction.setSenderAccountId(rs.getInt("sender_account_id"));
				transaction.setReceiverAccountId(rs.getInt("receiver_account_id"));
				transaction.setTransactionType(rs.getString("transaction_type"));
				transaction.setAmount(rs.getDouble("amount"));
				transaction.setTransactionDate(rs.getTimestamp("transaction_date"));
				transaction.setStatus(rs.getString("status"));
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}
}