package com.aurionpro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.aurionpro.model.Account;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final double MINIMUM_BALANCE = 500.0;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database.", e);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null || instance.isConnectionClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private boolean isConnectionClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch (SQLException e) {
            return true;
        }
    }

    public Connection getConnection() {
        if (isConnectionClosed()) {
            instance = new DatabaseConnection();
        }
        return connection;
    }

    public static void insertAccount(Account account) throws SQLException {
        Connection conn = getInstance().getConnection();
        String sql = "INSERT INTO accounts (accountId, accountHolderName, balance) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, account.getAccountId());
            stmt.setString(2, account.getAccountHolder());
            stmt.setDouble(3, account.getBalance());
            stmt.executeUpdate();
            System.out.println("Account created successfully!");
        }
    }

    public static double getMinimumBalance() {
        return MINIMUM_BALANCE;
    }
}