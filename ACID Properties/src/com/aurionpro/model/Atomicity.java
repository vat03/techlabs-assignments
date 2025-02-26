package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Atomicity {
	private Connection connection;

	public Atomicity() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	public void performAtomicTransaction(Account from, Account to, double amount) {
		try {
			connection.setAutoCommit(false); 

			// Check balance
			PreparedStatement checkStmt = connection
					.prepareStatement("SELECT balance FROM accounts WHERE account_id = ?");
			checkStmt.setInt(1, from.getAccountId());
			ResultSet rs = checkStmt.executeQuery();
			rs.next();
			double currentBalance = rs.getDouble("balance");

			if (currentBalance >= amount) {
				// Update from account
				PreparedStatement updateFrom = connection
						.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE account_id = ?");
				updateFrom.setDouble(1, amount);
				updateFrom.setInt(2, from.getAccountId());
				updateFrom.executeUpdate();

				// Update to account
				PreparedStatement updateTo = connection
						.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE account_id = ?");
				updateTo.setDouble(1, amount);
				updateTo.setInt(2, to.getAccountId());
				updateTo.executeUpdate();

				connection.commit();
				System.out.println("Transaction committed successfully!");
			} else {
				connection.rollback();
				System.out.println("Transaction rolled back: Insufficient funds!");
			}

			// Display updated balances
			displayBalances(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void displayBalances(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println("ID: " + rs.getInt("account_id") + ", Name: " + rs.getString("holder_name")
					+ ", Balance: " + rs.getDouble("balance"));
		}
	}
}
