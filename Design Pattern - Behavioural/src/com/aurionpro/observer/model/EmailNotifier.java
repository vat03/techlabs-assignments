package com.aurionpro.observer.model;

public class EmailNotifier implements INotifier {

	Account account;

	public EmailNotifier(Account account) {
		this.account = account;
	}

	public void depositMessage(double amount) {
		System.out.println("EMail: " + amount + " has been deposited to your account");
		System.out.println("New balance: " + account.getBalance());
	}

	public void withdrawMessage(double amount) {
		System.out.println("EMail: " + amount + " has been withdrawn from your account");
		System.out.println("New balance: " + account.getBalance());
	}

}
