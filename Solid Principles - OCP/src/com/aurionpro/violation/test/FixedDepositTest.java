package com.aurionpro.violation.test;

import java.util.Scanner;

import com.aurionpro.violation.model.FestivalType;
import com.aurionpro.violation.model.FixedDeposit;

public class FixedDepositTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		FixedDeposit fd = takeInput(scanner);

		System.out.println("\nInterest is: "+fd.calculateSimpleInterest());
	}

	public static FixedDeposit takeInput(Scanner scanner) {
		System.out.println("Enter your Account Number: ");
		int accountNumber = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter your name: ");
		String name = scanner.nextLine();

		System.out.println("Enter Principle amount: ");
		double principle = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Enter duration: ");
		int duration = scanner.nextInt();
		scanner.nextLine();

		FestivalType festival = selectFestival(scanner);

		FixedDeposit fd = new FixedDeposit(accountNumber, name, principle, duration, festival);
		return fd;
	}

	public static FestivalType selectFestival(Scanner scanner) {
		System.out.println("Festivals: ");
		System.out.println("1. NEW YEAR");
		System.out.println("2. DIWALI");
		System.out.println("3. HOLI");
		System.out.println("4. OTHERS");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		FestivalType festivalType = null;
		switch (choice) {
		case 1:
			festivalType = FestivalType.NEWYEAR;
			break;
		case 2:
			festivalType = FestivalType.DIWALI;
			break;
		case 3:
			festivalType = FestivalType.HOLI;
			break;
		default:
			festivalType = FestivalType.OTHERS;
			break;
		}

		return festivalType;
	}
}
