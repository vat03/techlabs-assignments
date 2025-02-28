//package com.aurionpro.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DatabaseConnection {
//    private static DatabaseConnection instance;
//    private Connection connection;
//    
//    private static final String URL = "jdbc:mysql://localhost:3306/college";
//    private static final String USER = "root";
//    private static final String PASSWORD = "root";
//
//    private DatabaseConnection() {
//        try {
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Database connected successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to connect to database.");
//        }
//    }
//
//    public static DatabaseConnection getInstance() {
//        if (instance == null) {
//            instance = new DatabaseConnection();
//        }
//        return instance;
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//}

//package com.aurionpro.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.logging.*;
//
//public class DatabaseConnection {
//    private static DatabaseConnection instance;
//    private Connection connection;
//    private static final String URL = "jdbc:mysql://localhost:3306/college";
//    private static final String USER = "root";
//    private static final String PASSWORD = "root";
//    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());
//
//    private DatabaseConnection() {
//        try {
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            LOGGER.info("Database connected successfully!");
//        } catch (SQLException e) {
//            LOGGER.severe("Failed to connect to database: " + e.getMessage());
//            throw new RuntimeException("Failed to connect to database.", e);
//        }
//    }
//
//    public static DatabaseConnection getInstance() {
//        if (instance == null) {
//            synchronized (DatabaseConnection.class) {
//                if (instance == null) {
//                    instance = new DatabaseConnection();
//                }
//            }
//        }
//        return instance;
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//}

package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static DatabaseConnection instance;
	private Connection connection;
	private static final String URL = "jdbc:mysql://localhost:3306/college";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private DatabaseConnection() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Database connected successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to connect to database.", e);
		}
	}

	public static DatabaseConnection getInstance() {
		if (instance == null) {
			synchronized (DatabaseConnection.class) {
				if (instance == null) {
					instance = new DatabaseConnection();
				}
			}
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}
}