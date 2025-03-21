package com.aurionpro.query;

import com.aurionpro.db.DatabaseConnection;
import com.aurionpro.entity.AccountEntity;
import com.aurionpro.entity.TransactionEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionQuery {
	private AccountQuery accountRepo = new AccountQuery();

	public void addTransaction(TransactionEntity transaction, boolean isSuccess) {
		String insertSql = "INSERT INTO transactions (sender_account_id, receiver_account_id, transaction_type, amount, sender_balance_after, receiver_balance_after, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			AccountEntity senderAccount = accountRepo.getAccountByNumber(transaction.getSenderAccountNumber());
			AccountEntity receiverAccount = accountRepo.getAccountByNumber(transaction.getReceiverAccountNumber());

			if (senderAccount == null || receiverAccount == null) {
				throw new SQLException("Sender or receiver account not found.");
			}

			if (isSuccess) {
				if ("debit".equals(transaction.getTransactionType())) {
					double newSenderBalance = senderAccount.getBalance() - transaction.getAmount();
					if (newSenderBalance < 0) {
						throw new SQLException("Insufficient balance in sender account (should be caught earlier).");
					}
					accountRepo.updateBalance(senderAccount.getAccountId(), newSenderBalance);
					transaction.setSenderBalanceAfter(newSenderBalance);
					transaction.setReceiverBalanceAfter(receiverAccount.getBalance());
				} else if ("credit".equals(transaction.getTransactionType())) {
					double newReceiverBalance = receiverAccount.getBalance() + transaction.getAmount();
					accountRepo.updateBalance(receiverAccount.getAccountId(), newReceiverBalance);
					transaction.setSenderBalanceAfter(newReceiverBalance);
					transaction.setReceiverBalanceAfter(newReceiverBalance);
				} else if ("transfer".equals(transaction.getTransactionType())) {
					double newSenderBalance = senderAccount.getBalance() - transaction.getAmount();
					double newReceiverBalance = receiverAccount.getBalance() + transaction.getAmount();
					if (newSenderBalance < 0) {
						throw new SQLException("Insufficient balance in sender account (should be caught earlier).");
					}
					accountRepo.updateBalance(senderAccount.getAccountId(), newSenderBalance);
					accountRepo.updateBalance(receiverAccount.getAccountId(), newReceiverBalance);
					transaction.setSenderBalanceAfter(newSenderBalance);
					transaction.setReceiverBalanceAfter(newReceiverBalance);
				}
			} else {
				transaction.setSenderBalanceAfter(senderAccount.getBalance());
				transaction.setReceiverBalanceAfter(receiverAccount.getBalance());
			}

			try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
				stmt.setInt(1, senderAccount.getAccountId());
				stmt.setInt(2, receiverAccount.getAccountId());
				stmt.setString(3, transaction.getTransactionType());
				stmt.setDouble(4, transaction.getAmount());
				stmt.setDouble(5, transaction.getSenderBalanceAfter());
				stmt.setDouble(6, transaction.getReceiverBalanceAfter());
				stmt.setString(7, transaction.getStatus());
				stmt.executeUpdate();
			}

			conn.commit();
			System.out.println("Transaction committed successfully: " + transaction.getTransactionId() + " Status: "
					+ transaction.getStatus());
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
					System.err.println("Transaction rolled back due to: " + e.getMessage());
				} catch (SQLException rollbackEx) {
					rollbackEx.printStackTrace();
				}
			}
			e.printStackTrace();
			throw new RuntimeException("Failed to add transaction: " + e.getMessage());
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

	public List<TransactionEntity> getAllTransactions(String sortField, String sortOrder) {
		List<TransactionEntity> transactions = new ArrayList<>();
		String validSortField = "transaction_id"; 
		if (sortField != null && (sortField.equals("transaction_id") || sortField.equals("sender_account_number")
				|| sortField.equals("receiver_account_number") || sortField.equals("amount")
				|| sortField.equals("sender_balance_after") || sortField.equals("receiver_balance_after")
				|| sortField.equals("transaction_date") || sortField.equals("status"))) {
			validSortField = sortField;
		}
		String validSortOrder = "ASC"; 
		if (sortOrder != null && sortOrder.equals("DESC")) {
			validSortOrder = "DESC";
		}

		String sql = "SELECT t.*, a1.account_number AS sender_account_number, a2.account_number AS receiver_account_number "
				+ "FROM transactions t " + "JOIN accounts a1 ON t.sender_account_id = a1.account_id "
				+ "JOIN accounts a2 ON t.receiver_account_id = a2.account_id " + "ORDER BY " + validSortField + " "
				+ validSortOrder;

		try (Connection conn = DatabaseConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				TransactionEntity transaction = new TransactionEntity();
				transaction.setTransactionId(rs.getInt("transaction_id"));
				transaction.setSenderAccountNumber(rs.getString("sender_account_number"));
				transaction.setReceiverAccountNumber(rs.getString("receiver_account_number"));
				transaction.setTransactionType(rs.getString("transaction_type"));
				transaction.setAmount(rs.getDouble("amount"));
				transaction.setSenderBalanceAfter(rs.getDouble("sender_balance_after"));
				transaction.setReceiverBalanceAfter(rs.getDouble("receiver_balance_after"));
				transaction.setTransactionDate(rs.getTimestamp("transaction_date"));
				transaction.setStatus(rs.getString("status"));
				transactions.add(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}

	public List<TransactionEntity> getTransactionsByAccountId(int accountId, String sortField, String sortOrder) {
		List<TransactionEntity> transactions = new ArrayList<>();
		String validSortField = "transaction_id"; 
		if (sortField != null && (sortField.equals("transaction_id") || sortField.equals("sender_account_number")
				|| sortField.equals("receiver_account_number") || sortField.equals("amount")
				|| sortField.equals("balance") || sortField.equals("transaction_date") || sortField.equals("status"))) {
			validSortField = sortField;
		}
		String validSortOrder = "ASC"; 
		if (sortOrder != null && sortOrder.equals("DESC")) {
			validSortOrder = "DESC";
		}

		String orderClause = "ORDER BY " + validSortField + " " + validSortOrder;
		if ("balance".equals(validSortField)) {
			orderClause = "ORDER BY CASE WHEN sender_account_id = ? THEN sender_balance_after ELSE receiver_balance_after END "
					+ validSortOrder;
		}

		String sql = "SELECT t.*, a1.account_number AS sender_account_number, a2.account_number AS receiver_account_number "
				+ "FROM transactions t " + "JOIN accounts a1 ON t.sender_account_id = a1.account_id "
				+ "JOIN accounts a2 ON t.receiver_account_id = a2.account_id "
				+ "WHERE t.sender_account_id = ? OR t.receiver_account_id = ? " + orderClause;

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, accountId);
			stmt.setInt(2, accountId);
			if ("balance".equals(validSortField)) {
				stmt.setInt(3, accountId); 
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TransactionEntity transaction = new TransactionEntity();
				transaction.setTransactionId(rs.getInt("transaction_id"));
				transaction.setSenderAccountNumber(rs.getString("sender_account_number"));
				transaction.setReceiverAccountNumber(rs.getString("receiver_account_number"));
				transaction.setTransactionType(rs.getString("transaction_type"));
				transaction.setAmount(rs.getDouble("amount"));
				transaction.setSenderBalanceAfter(rs.getDouble("sender_balance_after"));
				transaction.setReceiverBalanceAfter(rs.getDouble("receiver_balance_after"));
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