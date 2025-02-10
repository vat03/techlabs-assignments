package com.aurionpro.SwitchCase;

import java.util.Scanner;

public class SeasonDecider {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the month number: ");
		int monthNuber = scanner.nextInt();

		switch (monthNuber) {
		case 1:

		case 2:

		case 3:
			System.out.println("Winter Season");
			break;

		case 4:

		case 5:

		case 6:
			System.out.println("Summer Season");
			break;

		case 7:

		case 8:

		case 9:
			System.out.println("Monsoon Season");
			break;

		case 10:

		case 11:

		case 12:
			System.out.println("Autumn Season");
			break;
			
		default:
			System.out.println("Enter a valid month");
			break;
		}

		scanner.close();
	}
}
