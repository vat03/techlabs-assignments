package com.aurionpro;

public class ArithematicOperations {
	public static void main(String[] args) {
		int number1 = 50;
		int number2 = 5;

		int sum = number1 + number2;
		int difference = number1 - number2;
		int product = number1 * number2;
		int division = number1 / number2;
		int remainder = number1 % number2;

		System.out.println("Sum of " + number1 + " and " + number2 + " is "
				+ sum);
		System.out.println("Difference of " + number1 + " and " + number2
				+ " is " + difference);
		System.out.println("Product of " + number1 + " and " + number2 + " is "
				+ product);
		System.out.println("Quotient of " + number1 + " and " + number2
				+ " is " + division);
		System.out.println("Remainder of " + number1 + " and " + number2
				+ " is " + remainder);
	}
}
