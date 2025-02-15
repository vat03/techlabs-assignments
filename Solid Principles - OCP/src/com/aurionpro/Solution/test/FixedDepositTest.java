package com.aurionpro.Solution.test;

import java.util.Scanner;
import com.aurionpro.Solution.model.*;

public class FixedDepositTest {
	private static FixedDeposit fd;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		takeInput(scanner);

		double interest = calculateInterest(fd);

		displayOutput(interest);

		scanner.close();
	}

	private static void takeInput(Scanner scanner) {
		System.out.print("Enter Account Number: ");
		int accountNumber = scanner.nextInt();

		System.out.print("Enter Account Holder Name: ");
		scanner.nextLine();
		String name = scanner.nextLine();

		System.out.print("Enter Principle Amount: ");
		double principle = scanner.nextDouble();

		System.out.print("Enter Duration (in years): ");
		int duration = scanner.nextInt();

		System.out.print("Enter Festival (NewYear/Diwali/Holi/Others): ");
		scanner.nextLine();
		String festivalName = scanner.nextLine();

		FestivalInterest festivalInterest = getFestivalInterest(festivalName);

		fd = new FixedDeposit(accountNumber, name, principle, duration, festivalInterest);
	}

	private static FestivalInterest getFestivalInterest(String festivalName) {
		switch (festivalName.toLowerCase()) {
		case "newyear":
			return new NewYear();
		case "diwali":
			return new Diwali();
		case "holi":
			return new Holi();
		default:
			return new Others();
		}
	}

	private static double calculateInterest(FixedDeposit fd) {
		InterestCalculator calculator = new InterestCalculator(fd);
		return calculator.calculateInterest();
	}

	private static void displayOutput(double interest) {
		System.out.println("\n--- Fixed Deposit Details ---");
		System.out.println("Account Number: " + fd.getAccountNumber());
		System.out.println("Account Holder Name: " + fd.getName());
		System.out.println("Principle Amount: " + fd.getPrinciple());
		System.out.println("Duration: " + fd.getDuration() + " years");
		System.out.println("Festival: " + fd.getFestivalinterest().getClass().getSimpleName());
		System.out.println("Interest Rate: " + fd.getFestivalinterest().getInterestRate() + "%");
		System.out.println("Interest Amount: " + interest);
	}
}
