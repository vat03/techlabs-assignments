package com.aurionpro.observer.model;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.observer.exceptions.InsufficientFundsException;

public class Account {
	private String accountNumber;
	private String name;
	private double balance;
	private List<INotifier> notifiers = new ArrayList<>(); 
	
	public Account(String accountNumber, String name, double balance){
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAccountNumber(){
		return accountNumber;
	}
	
	public void deposit(double amount){
		if(amount <= 0){
			System.out.println("Enter a valid amount !!");
			return;
		}	
		balance += amount;
		for(INotifier notifier : notifiers) {
			notifier.depositMessage(amount);
		}
	}
	
	public void withdraw(double amount){
		if(amount <= 0){
			System.out.println("Enter a valid amount");
			return;
		} if (amount > balance){
			throw new InsufficientFundsException();
		}
		balance -= amount;
		for(INotifier notifier : notifiers) {
			notifier.withdrawMessage(amount);
		}
	}
	
	public void registerNotifier(String notifierOption, Account account) {
		if(notifierOption.equalsIgnoreCase("sms")) {
			notifiers.add(new SMSNotifier(account));
		}
		if(notifierOption.equalsIgnoreCase("whatsapp")) {
			notifiers.add(new WhatsappNotifier(account));
		}
		if(notifierOption.equalsIgnoreCase("email")) {
			notifiers.add(new EmailNotifier(account));
		}
	}

//	@Override
//	public String toString() {
//		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + ", notifiers="
//				+ notifiers + "]";
//	}
	
}
