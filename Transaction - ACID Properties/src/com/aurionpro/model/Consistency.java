package com.aurionpro.model;

import com.aurionpro.db.DatabaseConnection;
import java.sql.*;

public class Consistency {
	private Connection connection = DatabaseConnection.getInstance().getConnection();

	// Calculate total balance of all accounts
	private double getTotalBalance() throws SQLException {
		double total = 0;
		try (PreparedStatement stmt = connection.prepareStatement("SELECT SUM(balance) AS total FROM accounts");
				ResultSet rs = stmt.executeQuery()) {
			if (rs.next()) {
				total = rs.getDouble("total");
			} else {
				System.out.println("No accounts available to calculate total balance.");
			}
		}
		return total;
	}

	// Check consistency by comparing total balance before and after transaction
	public boolean checkConsistency(Account from, Account to, double amount, Atomicity atomicity) {
		try {
			// Get total balance before transaction
			double beforeTotal = getTotalBalance();
			System.out.printf("Total balance before transaction: %.2f%n", beforeTotal);

			// Perform the transaction
			atomicity.performAtomicTransaction(from, to, amount);

			// Get total balance after transaction
			double afterTotal = getTotalBalance();
			System.out.printf("Total balance after transaction: %.2f%n", afterTotal);

			// Check if totals before and after transaction match
			//boolean isConsistent = Math.abs(beforeTotal - afterTotal) < 0.01;
			boolean isConsistent;
			if (beforeTotal == afterTotal) {
				System.out.println("Consistency maintained: Total value unchanged.");
				isConsistent = true;
			} else {
				System.out.println("Consistency not maintained: Total value changed unexpectedly!");
				isConsistent = false;
			}
			return isConsistent;

		} catch (SQLException e) {
			System.out.println("Consistency check failed due to database error: " + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("Consistency check failed: " + e.getMessage());
			return false;
		}
	}
}