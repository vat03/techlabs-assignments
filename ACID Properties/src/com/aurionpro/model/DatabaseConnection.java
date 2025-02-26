//package com.aurionpro.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class DatabaseConnection {
//	private static DatabaseConnection instance;
//	private Connection connection;
//
//	private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
//	private static final String USER = "root";
//	private static final String PASSWORD = "root";
//
//	private DatabaseConnection() {
//		try {
//			connection = DriverManager.getConnection(URL, USER, PASSWORD);
//			System.out.println("Database connected successfully!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Failed to connect to database.");
//		}
//	}
//
//	public static DatabaseConnection getInstance() {
//		if (instance == null) {
//			instance = new DatabaseConnection();
//		}
//		return instance;
//	}
//
//	public Connection getConnection() {
//		return connection;
//	}
//
//	static Connection conn = DatabaseConnection.getInstance().getConnection();
//
//	public static void insertAccount(Account account) {
//		try {
//			PreparedStatement stmt = conn
//					.prepareStatement("INSERT INTO accounts (account_id, holder_name, balance) VALUES (?, ?, ?)");
//			stmt.setInt(1, account.getAccountId());
//			stmt.setString(2, account.getAccountHolder());
//			stmt.setDouble(3, account.getBalance());
//			stmt.executeUpdate();
//			System.out.println("Account inserted successfully!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}







package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to database.");
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
            e.printStackTrace();
            return true;
        }
    }

    public Connection getConnection() {
        if (isConnectionClosed()) { 
            instance = new DatabaseConnection();
        }
        return connection;
    }

//    public static void insertAccount(Account account) {
//        try (Connection conn = DatabaseConnection.getInstance().getConnection();
//             PreparedStatement stmt = conn.prepareStatement(
//                 "INSERT INTO accounts (account_id, holder_name, balance) VALUES (?, ?, ?)")) {
//            stmt.setInt(1, account.getAccountId());
//            stmt.setString(2, account.getAccountHolder());
//            stmt.setDouble(3, account.getBalance());
//            stmt.executeUpdate();
//            System.out.println("Account inserted successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
	

	public static void insertAccount(Account account) {
		Connection conn = DatabaseConnection.getInstance().getConnection();
		try {
			
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO accounts (account_id, holder_name, balance) VALUES (?, ?, ?)");
			stmt.setInt(1, account.getAccountId());
			stmt.setString(2, account.getAccountHolder());
			stmt.setDouble(3, account.getBalance());
			stmt.executeUpdate();
			System.out.println("Account inserted successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
