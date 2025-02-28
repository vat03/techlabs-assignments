package com.aurionpro.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.aurionpro.model.Account;
import com.aurionpro.model.Atomicity;
import com.aurionpro.model.Consistency;
import com.aurionpro.model.DatabaseConnection;
import com.aurionpro.model.Durability;
import com.aurionpro.model.Isolation;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnection.getInstance().getConnection();

        // Input for Account 1
        System.out.println("Enter details for Account 1:");
        System.out.print("Account ID: ");
        int id1 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Holder Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double balance1 = scanner.nextDouble();

        // Input for Account 2
        System.out.println("\nEnter details for Account 2:");
        System.out.print("Account ID: ");
        int id2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Holder Name: ");
        String name2 = scanner.nextLine();
        System.out.print("Initial Balance: ");
        double balance2 = scanner.nextDouble();

        // Create account objects
        Account account1 = new Account(id1, name1, balance1);
        Account account2 = new Account(id2, name2, balance2);

        // Insert accounts into database
        DatabaseConnection.insertAccount(account1);
        DatabaseConnection.insertAccount(account2);

        // Get transaction amount
        System.out.print("\nEnter transaction amount from " + name1 + " (ID " + id1 + ") to " + name2 + " (ID " + id2 + "): ");
        double amount = scanner.nextDouble();

        // Create ACID property objects
        Atomicity atomicity = new Atomicity();
        Consistency consistency = new Consistency();
        Isolation isolation = new Isolation();
        Durability durability = new Durability();

        // Perform transaction with ACID properties
        System.out.println("\nInitial State:");
        try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("account_id") + 
                                 ", Name: " + rs.getString("holder_name") + 
                                 ", Balance: " + rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (consistency.checkConsistency(account1, account2, amount)) {
            atomicity.performAtomicTransaction(account1, account2, amount);
            isolation.performIsolatedTransaction(account1, account2, 0); 
            durability.saveTransaction(account1, account2, amount);
            durability.showTransactionLog();
        }

        scanner.close();
    }
}
