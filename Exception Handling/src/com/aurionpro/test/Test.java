package com.aurionpro.test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Enter first number: ");
			int number1 = scanner.nextInt();

			System.out.print("Enter second number: ");
			int number2 = scanner.nextInt();

			double division = number1 / number2;

			System.out.println();

			System.out.println("Division of " + number1 + " and " + number2 + " is " + division);
		} catch (ArithmeticException exception) {
			System.out.println("Division by zero not possible");
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Two inputs are required for the operation.");
		} catch (Exception exception) {
			System.out.println("Unexpected error occured: " + exception);
		}

		System.out.println("Code ended !!");
		
		scanner.close();
	}
}
