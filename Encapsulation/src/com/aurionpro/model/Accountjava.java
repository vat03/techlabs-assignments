package com.aurionpro.model;

import com.aurionpro.test.AccountDetails.Account;

public class Accountjava {
	public static class AccountDetails {
		public static void main(String[] args) {
			Account account1 = new Account();

			account1.accountNumber = 16010121197l;
			account1.accountType = "Savings";
			account1.name = "Vatsal";
			account1.balance = 10000;
			
			account1.print();
		}
	}
}
