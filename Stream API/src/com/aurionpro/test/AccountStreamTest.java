package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.model.Account;

public class AccountStreamTest {
	public static void main(String[] args) {
		List<Account> accountList = new ArrayList<Account>();

		accountList.add(new Account(1, "abc", 1000));
		accountList.add(new Account(2, "xyz", 5000));
		accountList.add(new Account(3, "lmnopqrst", 800));

		// Minimum balance
		System.out.println("Account with Minimum balance: ");
		accountList.stream()
			.min(Comparator.comparingDouble(acc -> acc.getBalance()))
			.ifPresent(acc -> System.out.println(acc));
		
		System.out.println();
		
		// Maximum balance
		System.out.println("Account with Minimum balance: ");
		accountList.stream()
		.max(Comparator.comparingDouble(acc -> acc.getBalance()))
		.ifPresent(acc -> System.out.println(acc));
		
		System.out.println();
		
		// Name length greater than 6 character
		System.out.println("Accounts with Name greater than 6 characters: ");
		List<Account> namesGreaterThanSix = accountList.stream()
				.filter((acc) -> (acc.getName().length() > 6))
				.collect(Collectors.toList());
		
		namesGreaterThanSix.stream().forEach((acc) -> System.out.println(acc));
		
		System.out.println();
		
		// Total of balance of all accounts
		double totalBalance = accountList.stream()
				.mapToDouble((acc) -> acc.getBalance())
				.sum();
		
		System.out.println("Total of balance of all accounts is: "+totalBalance);
	}
}
