package com.aurionpro.model;

import com.aurionpro.db.DatabaseConnection;
import com.aurionpro.exceptions.*;
import java.sql.*;

public class Atomicity {
	private Connection connection;
	private static final double MINIMUM_BALANCE = DatabaseConnection.getMinimumBalance();

	public Atomicity() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	public void performAtomicTransaction(Account from, Account to, double amount)
			throws MinimumBalanceException, AccountNumberNotFoundException, InvalidAmountException {
		try {
			connection.setAutoCommit(false);

			// Validate if accounts exist
			if (!accountExists(from.getAccountId()) || !accountExists(to.getAccountId())) {
				throw new AccountNumberNotFoundException("One or both account numbers not found");
			}

			// Validate amount
			if (amount <= 0) {
				throw new InvalidAmountException("Amount must be positive");
			}

			// Check current balance
			double fromBalance = getBalance(from.getAccountId());
			if (fromBalance - amount < MINIMUM_BALANCE) {
				throw new MinimumBalanceException(
						"Transaction not possible as Minimum balance of " + MINIMUM_BALANCE + " Rs. is required");
			}

			// Perform transfer
			updateBalance(from.getAccountId(), -amount);
			updateBalance(to.getAccountId(), amount);

			connection.commit();
			System.out.println("Transaction completed successfully!");
			displayBalances();

		} catch (SQLException e) {
			try {
				connection.rollback();
				System.out.println("Transaction rolled back due to error");
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
			}
			throw new RuntimeException("Database error during transaction", e);
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean accountExists(int accountId) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM accounts WHERE accountId = ?");
		stmt.setInt(1, accountId);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		return rs.getInt(1) > 0;
	}

	private double getBalance(int accountId) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT balance FROM accounts WHERE accountId = ?");
		stmt.setInt(1, accountId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getDouble("balance");
		}
		throw new SQLException("Account not found");
	}

	private void updateBalance(int accountId, double amount) throws SQLException {
		PreparedStatement stmt = connection
				.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE accountId = ?");
		stmt.setDouble(1, amount);
		stmt.setInt(2, accountId);
		stmt.executeUpdate();
	}

	public void displayBalances() throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM accounts");
		ResultSet rs = stmt.executeQuery();
		System.out.println("\nCurrent Account Balances:");
		boolean hasAccounts = false;
		while (rs.next()) {
			hasAccounts = true;
			System.out.printf("ID: %d, Name: %s, Balance: %.2f%n", rs.getInt("accountId"),
					rs.getString("accountHolderName"), rs.getDouble("balance"));
		}
		if (!hasAccounts) {
			System.out.println("No accounts found in the system.");
		}
	}
}