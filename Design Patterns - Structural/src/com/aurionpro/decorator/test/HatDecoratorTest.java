package com.aurionpro.decorator.test;

import java.util.Scanner;

import com.aurionpro.decorator.model.GoldenHat;
import com.aurionpro.decorator.model.IHat;
import com.aurionpro.decorator.model.PremiumHat;
import com.aurionpro.decorator.model.RibbonedHat;
import com.aurionpro.decorator.model.StandardHat;

public class HatDecoratorTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		takeInput(scanner);
	}

	public static void takeInput(Scanner scanner) {
		System.out.println("Enter which type of Hat do you want to buy (Standard/Premium): ");
		String baseChoice = scanner.nextLine().toLowerCase();

		if (baseChoice.equals("standard")) {
			IHat standardHat = new StandardHat();
			System.out.println("Do you want to buy GOLDEN / RIBBONED Hat: ");
			String secondaryChoice = scanner.nextLine().toLowerCase();
			if (secondaryChoice.equals("golden")) {
				GoldenHat standardGoldenHat = new GoldenHat(standardHat);
				System.out.println("\nProduct: " + standardGoldenHat.getDescription());
				System.out.println("Total Price: " + standardGoldenHat.getPrice());
				return;
			}
			if (secondaryChoice.equals("ribboned")) {
				RibbonedHat standardRibbonedHat = new RibbonedHat(standardHat);
				System.out.println("\nProduct: " + standardRibbonedHat.getDescription());
				System.out.println("Total Price: " + standardRibbonedHat.getPrice());
				return;
			}
			System.out.println("Product: " + standardHat.getDescription());
			System.out.println("Total Price: " + standardHat.getPrice());
			return;
		}
		if (baseChoice.equals("premium")) {
			IHat premiumHat = new PremiumHat();
			System.out.println("Do you want to buy GOLDEN / RIBBONED Hat: ");
			String secondaryChoice = scanner.nextLine().toLowerCase();
			if (secondaryChoice.equals("golden")) {
				GoldenHat premiumGoldenHat = new GoldenHat(premiumHat);
				System.out.println("\nProduct: " + premiumGoldenHat.getDescription());
				System.out.println("Total Price: " + premiumGoldenHat.getPrice());
				return;
			}
			if (secondaryChoice.equals("ribboned")) {
				RibbonedHat premiumRibbonedHat = new RibbonedHat(premiumHat);
				System.out.println("\nProduct: " + premiumRibbonedHat.getDescription());
				System.out.println("Total Price: " + premiumRibbonedHat.getPrice());
				return;
			}
			System.out.println("\nProduct: " + premiumHat.getDescription());
			System.out.println("Total Price: " + premiumHat.getPrice());
			return;
		}
		System.out.println("\nEnter a valid choice !!");
	}
}
