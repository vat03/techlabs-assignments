package com.aurionpro.Day2HW;

import java.util.Scanner;
import java.util.Random;

public class NumberGuesserApp {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int numberOfAttempts = 0;
		int maximumNumberOfAttempts = 5;
		String userChoice = "";
		int guessedNumber = 0;

		System.out.println("Welcome to Number Guessing Game");
		System.out
				.println("\nRules: You have maximum 5 attempts to guess the number and win the game !!");

		do {
			int randomNumberGenerated = random.nextInt(100) + 1;

			while (maximumNumberOfAttempts > 0) {
				System.out.print("\nGuess the number: ");
				guessedNumber = scanner.nextInt();

				if (guessedNumber < randomNumberGenerated) {
					System.out.println("Sorry Too low !!");
					numberOfAttempts = numberOfAttempts + 1;
					maximumNumberOfAttempts = maximumNumberOfAttempts - 1;
					if (numberOfAttempts == 5) {
						System.out.println("\nAll Attempts exhausted !!");
					}
				} else if (guessedNumber > randomNumberGenerated) {
					System.out.println("Sorry Too high !!");
					numberOfAttempts = numberOfAttempts + 1;
					maximumNumberOfAttempts = maximumNumberOfAttempts - 1;
					if (numberOfAttempts == 5) {
						System.out.println("All Attempts exhausted !!");
					}
				} else {
					System.out
							.println("Congratulations !! You Guessed the number Correctly");
					numberOfAttempts = numberOfAttempts + 1;
					maximumNumberOfAttempts = maximumNumberOfAttempts - 1;
					System.out.println("You won in attempt " + numberOfAttempts+ ".");
					break;
				}
			}
			System.out.println("\nDo you want to play more ?");
			scanner.nextLine();
			userChoice = scanner.nextLine();
			numberOfAttempts = 0;
			maximumNumberOfAttempts = 5;
			System.out.println();
		} while (userChoice.equalsIgnoreCase("Yes"));
		System.out.println("Goodbye !!");
		scanner.close();
	}
}
