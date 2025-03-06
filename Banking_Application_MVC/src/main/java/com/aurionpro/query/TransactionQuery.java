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
		String insertSql = "INSERT INTO transactions (sender_account_id, receiver_account_id, transaction_type, amount, status) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		try {
			conn = DatabaseConnection.getConnection();
			conn.setAutoCommit(false);

			AccountEntity senderAccount = accountRepo.getAccountByNumber(transaction.getSenderAccountNumber());
			AccountEntity receiverAccount = accountRepo.getAccountByNumber(transaction.getReceiverAccountNumber());

			if (senderAccount == null || receiverAccount == null) {
				throw new SQLException("Sender or receiver account not found.");
			}

			// Update balances only if the transaction is successful
			if (isSuccess) {
				if ("debit".equals(transaction.getTransactionType())) {
					double newSenderBalance = senderAccount.getBalance() - transaction.getAmount();
					if (newSenderBalance < 0) {
						throw new SQLException("Insufficient balance in sender account");
					}
					accountRepo.updateBalance(senderAccount.getAccountId(), newSenderBalance);
					transaction.setSenderBalanceAfter(newSenderBalance);
				} else if ("credit".equals(transaction.getTransactionType())) {
					double newReceiverBalance = receiverAccount.getBalance() + transaction.getAmount();
					accountRepo.updateBalance(receiverAccount.getAccountId(), newReceiverBalance);
					transaction.setSenderBalanceAfter(senderAccount.getBalance());
				} else if ("transfer".equals(transaction.getTransactionType())) {
					double newSenderBalance = senderAccount.getBalance() - transaction.getAmount();
					double newReceiverBalance = receiverAccount.getBalance() + transaction.getAmount();
					if (newSenderBalance < 0) {
						throw new SQLException("Insufficient balance in sender account");
					}
					accountRepo.updateBalance(senderAccount.getAccountId(), newSenderBalance);
					accountRepo.updateBalance(receiverAccount.getAccountId(), newReceiverBalance);
					transaction.setSenderBalanceAfter(newSenderBalance);
				}
			} else {
				// For failed transactions, set balance without updating
				transaction.setSenderBalanceAfter(senderAccount.getBalance());
			}

			try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
				stmt.setInt(1, senderAccount.getAccountId());
				stmt.setInt(2, receiverAccount.getAccountId());
				stmt.setString(3, transaction.getTransactionType());
				stmt.setDouble(4, transaction.getAmount());
				stmt.setString(5, transaction.getStatus());
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

	public List<TransactionEntity> getAllTransactions() {
		List<TransactionEntity> transactions = new ArrayList<>();
		String sql = "SELECT t.*, a1.account_number AS sender_account_number, a2.account_number AS receiver_account_number, a1.balance AS sender_balance "
				+ "FROM transactions t " + "JOIN accounts a1 ON t.sender_account_id = a1.account_id "
				+ "JOIN accounts a2 ON t.receiver_account_id = a2.account_id";
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
				transaction.setSenderBalanceAfter(rs.getDouble("sender_balance"));
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
		String sql = "SELECT t.*, a1.account_number AS sender_account_number, a2.account_number AS receiver_account_number, a1.balance AS sender_balance "
				+ "FROM transactions t " + "JOIN accounts a1 ON t.sender_account_id = a1.account_id "
				+ "JOIN accounts a2 ON t.receiver_account_id = a2.account_id "
				+ "WHERE t.sender_account_id = ? OR t.receiver_account_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, accountId);
			stmt.setInt(2, accountId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				TransactionEntity transaction = new TransactionEntity();
				transaction.setTransactionId(rs.getInt("transaction_id"));
				transaction.setSenderAccountNumber(rs.getString("sender_account_number"));
				transaction.setReceiverAccountNumber(rs.getString("receiver_account_number"));
				transaction.setTransactionType(rs.getString("transaction_type"));
				transaction.setAmount(rs.getDouble("amount"));
				transaction.setSenderBalanceAfter(rs.getDouble("sender_balance"));
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
