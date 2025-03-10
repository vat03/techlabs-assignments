package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;
import com.aurionpro.model.*;

public class AccountTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Account account = null;

		while (true) {
			System.out.println(
					"\n1. Create Savings Account\n2. Create Current Account\n3. View Balance\n4. Deposit Amount\n5. Withdraw Amount\n6. Exit");
			System.out.print("\nEnter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: // Create Savings Account
				if (account == null) {
					account = new SavingsAccount();
					createSavingsAccount(account, scanner);
					displayDetails(account);
				} else {
					System.out.println("Account already exists!");
				}
				break;

			case 2: // Create Current Account
				if (account == null) {
					account = new CurrentAccount();
					createCurrentAccount(account, scanner);
					displayDetails(account);
				} else {
					System.out.println("Account already exists!");
				}
				break;

			case 3: // View Balance
				if (account != null) {
					System.out.println("Your balance is: " + account.getBalance());
				} else {
					System.out.println("No account found! Create an account first.");
				}
				break;

			case 4: // Deposit
				if (account != null) {
					System.out.print("Enter deposit amount: ");
					double depositAmount = scanner.nextDouble();
					account.deposit(depositAmount);
				} else {
					System.out.println("No account found! Create an account first.");
				}
				break;

			case 5: // Withdraw
				if (account != null) {
					System.out.print("Enter withdraw amount: ");
					double withdrawAmount = scanner.nextDouble();
					account.withdraw(withdrawAmount);
				} else {
					System.out.println("No account found! Create an account first.");
				}
				break;

			case 6: // Exit
				System.out.println("Thank you for using our Banking System!");
				return;

			default:
				System.out.println("Enter a valid choice!");
			}
		}
	}

	static {
		System.out.println("Welcome to the Banking Application");
	}

	// Create Savings Account using Setter Methods
	private static void createSavingsAccount(Account account, Scanner scanner) {
		System.out.print("Enter your name: ");
		scanner.nextLine(); // Consume newline
		((SavingsAccount) account).setName(scanner.nextLine());

		System.out.print("Enter initial balance (Minimum 500 required): ");
		double balance = scanner.nextDouble();
		while (balance < 500) {
			System.out.print("Insufficient balance! Enter at least 500: ");
			balance = scanner.nextDouble();
		}
		((SavingsAccount) account).setBalance(balance);

		System.out.print("Enter interest rate: ");
		((SavingsAccount) account).setInterestRate(scanner.nextDouble());

		((SavingsAccount) account).setAccountNumber(generateAccountNumber());
	}

	// Create Current Account using Setter Methods
	private static void createCurrentAccount(Account account, Scanner scanner) {
		System.out.print("Enter your name: ");
		scanner.nextLine(); // Consume newline
		((CurrentAccount) account).setName(scanner.nextLine());

		System.out.print("Enter initial balance: ");
		((CurrentAccount) account).setBalance(scanner.nextDouble());

		System.out.print("Enter overdraft limit: ");
		((CurrentAccount) account).setOverdraftLimit(scanner.nextDouble());

		((CurrentAccount) account).setAccountNumber(generateAccountNumber());
	}

	// Display Account Details
	private static void displayDetails(Account account) {
		System.out.println("\nYour Account Details:");
		System.out.println("Name: " + account.getName());
		System.out.println("Account Number: " + account.getAccountNumber());
		System.out.println("Balance: " + account.getBalance());

		if (account instanceof SavingsAccount) {
			System.out.println("Interest Rate: " + ((SavingsAccount) account).getInterestRate());
		} else if (account instanceof CurrentAccount) {
			System.out.println("Overdraft Limit: " + ((CurrentAccount) account).getOverdraftLimit());
		}
	}

	// Generate Random Account Number
	private static int generateAccountNumber() {
		Random random = new Random();
		return 1000 + random.nextInt(9000);
	}
}
