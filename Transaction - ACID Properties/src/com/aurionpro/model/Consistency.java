package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consistency {
	Connection connection = DatabaseConnection.getInstance().getConnection();
	
    public boolean checkConsistency(Account from, Account to, double amount) {
        try {
            if (amount <= 0) {
                System.out.println("Invalid amount: Must be positive");
                return false;
            }

            PreparedStatement stmt = connection.prepareStatement("SELECT balance FROM accounts WHERE account_id = ?");
            stmt.setInt(1, from.getAccountId());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            double balance = rs.getDouble("balance");

            if (balance < amount) {
                System.out.println("Invalid transaction: Insufficient balance");
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
