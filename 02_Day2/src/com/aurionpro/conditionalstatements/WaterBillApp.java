package com.aurionpro.conditionalstatements;

import java.util.Scanner;

public class WaterBillApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of units consumed: ");
		int unitsConsumed = scanner.nextInt();

		int meterCharge = 75;
		int unitcharge = 0;

		if (unitsConsumed >= 0) {
			if (unitsConsumed <= 100) {
				unitcharge = unitsConsumed * 5;
			} else {
				if (unitsConsumed <= 250) {
					unitcharge = unitsConsumed * 10;
				} else {
					unitcharge = unitsConsumed * 20;
				}
			}
			int totalWaterBill = unitcharge + meterCharge;

			System.out.println("\nUnit charge: "+unitcharge);
			System.out.println("Meter charge: "+meterCharge);
			System.out.println("\nTotal Water bill: " + totalWaterBill);

		} else {
			System.out.println("\nEnter valid number of unit consumed !!");
		}

		scanner.close();
	}
}
