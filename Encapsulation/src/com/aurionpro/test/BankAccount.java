package com.aurionpro.test;

import java.util.Scanner;
import com.aurionpro.model.BankAccountDetails;

public class BankAccount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		using constructor
		BankAccountDetails account1 = new BankAccountDetails(100, "Vatsal", 550.5);

//		Using getter setter methods
//		System.out.println("Enter account number: ");
//		account1.setAccountNumber(scanner.nextLong());
//
//		System.out.println("Enter account holder name: ");
//		scanner.nextLine();
//		account1.setHolderName(scanner.nextLine());
//
//		System.out.println("Enter balance: ");
//		account1.setBalance(scanner.nextDouble());

		while (true) {
			System.out.println("\nEnter the number of operation you want to perform: ");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Display Balance");
			System.out.println("4. Exit");
			
			int inputChoice = scanner.nextInt();

			if (inputChoice == 1) 
			{
				System.out.println("Enter deposit amount: ");
				double depositAmount = scanner.nextDouble();
				account1.deposit(depositAmount);
				account1.displayBalance();
			} 
			else if (inputChoice == 2) {
				System.out.println("Enter withdrawal amount: ");
				double withdrawalAmount = scanner.nextDouble();
				account1.withdraw(withdrawalAmount);
				account1.displayBalance();
			} 
			else if (inputChoice == 3) {
				account1.displayBalance();
			} 
			else if(inputChoice == 4)
			{
				System.out.println("Thanks for your interest !!");
				scanner.close();
				return;
			}
			else 
			{
				System.out.println("Enter a valid choice !!");
			}
		}
	}
}