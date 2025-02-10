package com.aurionpro.test;

public class AccountDetails {
	public static void main(String[] args) {
		Account account1 = new Account();

		account1.accountNumber = 16010121197l;
		account1.accountType = "Savings";
		account1.name = "Vatsal";
		account1.balance = 10000;
		
		account1.print();
	}

	public static class Account {
		public long accountNumber;
		public String accountType;
		public String name;
		public double balance;
		
		public void print()
		{
			System.out.println(accountNumber);
			System.out.println(accountType);
			System.out.println(name);
			System.out.println(balance);
		}
	}
	
	
}
