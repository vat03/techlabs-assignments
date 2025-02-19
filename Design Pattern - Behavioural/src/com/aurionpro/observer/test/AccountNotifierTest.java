package com.aurionpro.observer.test;

import java.util.Scanner;

import com.aurionpro.observer.exceptions.InsufficientFundsException;
import com.aurionpro.observer.model.Account;

public class AccountNotifierTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Account account = takeInput(scanner);

		chooseNotifier(scanner, account);

		System.out.println();

		chooseOperation(scanner, account);
	}

	public static Account takeInput(Scanner scanner) {
		System.out.println("Enter account number: ");
		String accountNumber = scanner.nextLine();
		System.out.println("Enter name: ");
		String name = scanner.nextLine();
		System.out.println("Enter balance: ");
		double balance = scanner.nextDouble();
		scanner.nextLine();

		Account account = new Account(accountNumber, name, balance);
		return account;
	}

	public static void chooseNotifier(Scanner scanner, Account account) {
		boolean sms = false;
		boolean whatsapp = false;
		boolean email = false;
		while (true) {
			System.out.println("Choose a notifier");
			System.out.println("1. SMS");
			System.out.println("2. WhatsApp");
			System.out.println("3. EMail");
			System.out.println("4. Exit");
			System.out.print("Enter your option: ");
			String choice = scanner.nextLine();
			switch (choice.toLowerCase()) {
			case "sms":
				if (sms) {
					System.out.println("already added");
					break;
				}
				sms = true;
				account.registerNotifier("sms", account);
				System.out.println("Success");
				break;
			case "whatsapp":
				if (whatsapp) {
					System.out.println("already added");
					break;
				}
				whatsapp = true;
				account.registerNotifier("whatsapp", account);
				System.out.println("Success");
				break;
			case "email":
				if (email) {
					System.out.println("already added");
					break;
				}
				email = true;
				account.registerNotifier("email", account);
				System.out.println("Success");
				break;
			case "exit":
				return;
			default:
				System.out.println("Enter correct option");
				break;
			}
		}
	}

	public static void chooseOperation(Scanner scanner, Account account) {
		while (true) {
			System.out.println("Enter the operation you want to perform: ");
			System.out.println("1. Deposit\n2. Withdraw\n3. Exit");
			String input = scanner.nextLine();

			switch (input.toLowerCase()) {
			case "deposit":
				System.out.println("Enter the amount to be deposited: ");
				account.deposit(scanner.nextDouble());
				scanner.nextLine();
				break;
			case "withdraw":
				try {
					System.out.println("Enter the amount to withdraw: ");
					account.withdraw(scanner.nextDouble());
					scanner.nextLine();
				} catch (InsufficientFundsException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;
			case "exit":
				System.out.println("Exiting !!");
				return;
			default:
				System.out.println("Enter a valid option !!");
				break;
			}
		}
	}
}