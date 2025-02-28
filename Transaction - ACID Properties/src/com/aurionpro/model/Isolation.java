package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Isolation {
	private Connection connection;

	public Isolation() {
		this.connection = DatabaseConnection.getInstance().getConnection();
	}

	public void performIsolatedTransaction(Account from, Account to, double amount) {
		try {
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); // Ensure isolation

			PreparedStatement updateFrom = connection
					.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE account_id = ?");
			updateFrom.setDouble(1, amount);
			updateFrom.setInt(2, from.getAccountId());
			updateFrom.executeUpdate();

			PreparedStatement updateTo = connection
					.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE account_id = ?");
			updateTo.setDouble(1, amount);
			updateTo.setInt(2, to.getAccountId());
			updateTo.executeUpdate();

			connection.commit();
			System.out.println("Isolated transaction completed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
