package com.aurionpro.test;

import java.util.Scanner;
import com.aurionpro.model.AccountSort;

public class AccountSortTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of accounts to be created: ");
		int numberOfAccounts = scanner.nextInt();
		
		AccountSort[] accounts = new AccountSort[numberOfAccounts];
		
		//input
		for(int i = 0; i < accounts.length; i++)
		{
			accounts[i] = new AccountSort();
			takeInut(accounts[i], scanner);
			System.out.println();
		}
		
		System.out.println("Accounts with their details (UNSORTED): \n");
		
		//output
		for (AccountSort account : accounts) {
			displayDetails(account);
		}
		
		//calling the sort function
		sort(accounts);
		
		//Sorted array
		
		System.out.println("\nAccounts with their details (SORTED): \n");
		for (AccountSort account : accounts) {
			displayDetails(account);
		}
		scanner.close();
	}
	
	public static void takeInut(AccountSort account, Scanner scanner)
	{
//		System.out.println("Enter account number: ");
//		account.setAccountNumber(scanner.nextLong());
		System.out.println("Enter your name: ");
		scanner.nextLine();
		account.setName(scanner.nextLine());
		while(account.getBalance() < 500)
		{
			System.out.println("Enter your initial balance (Minimum 500 required): ");
			account.setBalance(scanner.nextDouble());
		}
	}
	
	public static void displayDetails(AccountSort account)
	{
		System.out.print("Name: ");
		System.out.println(account.getName());
		System.out.print("Account number: ");
		System.out.println(account.getAccountNumber());
		System.out.print("Balance: ");
		System.out.println(account.getBalance());
		System.out.println();
	}
	
	public static void sort(AccountSort[] accounts)
	{	
		for (int i = 0; i < accounts.length - 1; i++) {
			for (int j = 0; j < accounts.length - i - 1; j++) {
				if(accounts[j].getBalance() > accounts[j+1].getBalance())
				{
					swap(accounts, j);
				}
			}
		}
	}
	
	public static void swap(AccountSort[] accounts, int index)
	{
		AccountSort temp = accounts[index];
		accounts[index] = accounts[index+1];
		accounts[index+1] = temp;
	}
}
