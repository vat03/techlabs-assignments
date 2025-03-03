package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.MinimumBalanceException;
import com.aurionpro.exception.NegativeAmountException;
import com.aurionpro.model.Account;

public class AccountTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Account account1 = null;

		while (true) {
			System.out.println("\n1. Create Account\n2. View Balance\n3. Deposit Amount\n4. Withdraw Amount\n5. Exit");
			System.out.print("\nEnter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: // Create Account
				if (account1 == null) {
//					account = new Account(1001, "Vatsal", 700);
					try {
						account1 = new Account(1001, "Vatsal", 700);
						System.out.println(account1);
					} catch (NegativeAmountException exception) {
						System.out.println(exception.getMessage());
					} catch (MinimumBalanceException exception) {
						System.out.println(exception.getMessage());
					}
				} else {
					System.out.println("Account already exists!");
				}
				break;

			case 2: // View Balance
				if (account1 != null) {
					System.out.println("Your balance is: " + account1.getBalance());
				} else {
					System.out.println("No account found! Create an account first.");
				}
				break;

			case 3: // Deposit
				if (account1 != null) {
					System.out.print("Enter deposit amount: ");
					double depositAmount = scanner.nextDouble();
					try {
						account1.deposit(depositAmount);
					} catch (NegativeAmountException exception) {
						System.out.println(exception.getMessage());
					} catch (MinimumBalanceException exception) {
						System.out.println(exception.getMessage());
					}
				} else {
					System.out.println("No account found! Create an account first.");
				}
				break;

			case 4: // Withdraw
				if (account1 != null) {
					System.out.print("Enter withdraw amount: ");
					double withdrawAmount = scanner.nextDouble();
					try {
						account1.withdraw(withdrawAmount);
					} catch (NegativeAmountException exception) {
						System.out.println(exception.getMessage());
					} catch (MinimumBalanceException exception) {
						System.out.println(exception.getMessage());
					}

				} else {
					System.out.println("No account found! Create an account first.");
				}
				break;

			case 5: // Exit
				System.out.println("Thank you for using our Banking System!");
				scanner.close();
				return;

			default:
				System.out.println("Enter a valid choice!");
			}
		}
	}
}
