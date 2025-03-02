package com.aurionpro.model;

import com.aurionpro.db.DatabaseConnection;
import com.aurionpro.exceptions.*;
import java.sql.SQLException;
import java.util.Scanner;

public class BankFacade {
	private Scanner scanner;
	private Atomicity atomicity;
	private Consistency consistency;
	private Durability durability;

	public BankFacade() {
		this.scanner = new Scanner(System.in);
		this.atomicity = new Atomicity();
		this.consistency = new Consistency();
		this.durability = new Durability();
	}

	public void start() {
		while (true) {
			displayMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			try {
				switch (choice) {
				case 1:
					createAccount();
					break;
				case 2:
					viewAccountDetails();
					break;
				case 3:
					performTransfer();
					break;
				case 4:
					viewTransactionLog();
					break;
				case 5:
					System.out.println("\nThanks for using my Banking Application !!");
					System.out.println("Exiting the Application");
					scanner.close();
					return;
				default:
					System.out.println("Invalid choice! Please select a number between 1 and 5.");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private void displayMenu() {
		System.out.println("\n=====================");
		System.out.println(" Banking System Menu ");
		System.out.println("=====================\n");
		System.out.println("1. Create Account");
		System.out.println("2. View Account Details");
		System.out.println("3. Perform Fund Transfer");
		System.out.println("4. View Transaction History");
		System.out.println("5. Exit");
		System.out.print("Enter choice: ");
	}

	private void createAccount() throws SQLException {
		System.out.print("Enter Account ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Holder Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Initial Balance: ");
		double balance = scanner.nextDouble();

		Account account = new Account(id, name, balance);
		DatabaseConnection.insertAccount(account);
	}

	private void viewAccountDetails() throws SQLException {
		atomicity.displayBalances();
	}

	private void performTransfer()
			throws MinimumBalanceException, AccountNumberNotFoundException, InvalidAmountException {
		System.out.print("Enter From Account ID: ");
		int fromId = scanner.nextInt();
		System.out.print("Enter To Account ID: ");
		int toId = scanner.nextInt();
		System.out.print("Enter Amount: ");
		double amount = scanner.nextDouble();

		Account from = new Account(fromId, "", 0);
		Account to = new Account(toId, "", 0);

		// Check consistency
		if (consistency.checkConsistency(from, to, amount, atomicity)) {
			// Logging occurs only if transaction is consistent
			durability.saveTransaction(from, to, amount);
		} else {
			System.out.println("Transaction not logged due to inconsistency or failure.");
		}
	}

	private void viewTransactionLog() {
		durability.showTransactionLog();
	}
}