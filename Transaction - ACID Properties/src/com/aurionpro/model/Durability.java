package com.aurionpro.model;

import com.aurionpro.db.DatabaseConnection;
import java.sql.*;

public class Durability {
	private Connection connection;

	public Durability() {
		this.connection = DatabaseConnection.getInstance().getConnection();
//		try (PreparedStatement stmt = connection.prepareStatement(
//				"CREATE TABLE IF NOT EXISTS transaction_log (id INT AUTO_INCREMENT PRIMARY KEY, from_id INT, to_id INT, amount DOUBLE, transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")) {
//			stmt.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public void saveTransaction(Account from, Account to, double amount) {
		try {
			connection.setAutoCommit(false);
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO transaction_log (from_id, to_id, amount) VALUES (?, ?, ?)");
			stmt.setInt(1, from.getAccountId());
			stmt.setInt(2, to.getAccountId());
			stmt.setDouble(3, amount);
			stmt.executeUpdate();
			connection.commit();
			System.out.println("Transaction saved to log");
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void showTransactionLog() {
		try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM transaction_log");
				ResultSet rs = stmt.executeQuery()) {
			System.out.println("Transaction History:");
			boolean hasTransactions = false;
			while (rs.next()) {
				hasTransactions = true;
				System.out.printf("ID: %d, From: %d, To: %d, Amount: %.2f, Date: %s%n", rs.getInt("id"),
						rs.getInt("from_id"), rs.getInt("to_id"), rs.getDouble("amount"),
						rs.getTimestamp("transaction_date"));
			}
			if (!hasTransactions) {
				System.out.println("No transactions recorded yet.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error retrieving transaction history: " + e.getMessage());
		}
	}
}