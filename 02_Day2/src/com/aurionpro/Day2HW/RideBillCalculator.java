package com.aurionpro.Day2HW;

import java.util.Scanner;

public class RideBillCalculator {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("This is a Ride Billing System");
		System.out.println();

		int totalBill = 0;
		int rideCharge = 0;
		int photoCharge = 0;

		System.out.print("Enter your height: ");
		int height = scanner.nextInt();

		if (height > 0) {
			if (height > 120) {
				System.out.println("\nCongratulations !! You can Ride.");

				System.out.print("\nEnter your age: ");
				int age = scanner.nextInt();

				if (age < 12) {
					rideCharge = 5;
				} else if (age >= 12 && age < 18) {
					rideCharge = 7;
				} else if (age >= 18) {
					if (age >= 45 && age <= 55) {
						rideCharge = 0;
					} else {
						rideCharge = 12;
					}
				}

				System.out.println("\nDo you want Photos?: ");
				scanner.nextLine();
				String photosRequired = scanner.nextLine();

				if (photosRequired.equalsIgnoreCase("yes")) {
					photoCharge = 3;
				} else {
					photoCharge = 0;
				}

				totalBill = rideCharge + photoCharge;

				System.out
						.println("\nYour Ride charge is: " + rideCharge + "$");
				System.out
						.println("Your Photo charge is: " + photoCharge + "$");
				System.out.println("\nYour Total bill is: " + totalBill + "$");
			} else {
				System.out
						.println("\nSorry, Your height is less than 120 cms !! You cannot Ride.");
			}
		} else {
			System.out.println("\nEnter valid height !!");
		}

		scanner.close();
	}
}
