package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Durability {
    private Connection connection;

    public Durability() {
        this.connection = DatabaseConnection.getInstance().getConnection();
        // Create transaction log table
        try (PreparedStatement stmt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS transaction_log (id INT AUTO_INCREMENT PRIMARY KEY, from_id INT, to_id INT, amount DOUBLE)")) {
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveTransaction(Account from, Account to, double amount) {
        try {
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO transaction_log (from_id, to_id, amount) VALUES (?, ?, ?)");
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
        }
    }

    public void showTransactionLog() {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM transaction_log");
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Transaction History:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", From: " + rs.getInt("from_id") + ", To: "
                        + rs.getInt("to_id") + ", Amount: " + rs.getDouble("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
