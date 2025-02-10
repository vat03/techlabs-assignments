package com.aurionpro;

public class Calcultor {

	static double number1 = 100;
	static double number2 = 33;

	static double add(double number1, double number2) {
		return number1 + number2;
	}

	static double subtract(double number1, double number2) {
		return number1 - number2;
	}

	static double multiply(double number1, double number2) {
		return number1 * number2;
	}

	static double divide(double number1, double number2) {
		return number1 / number2;
	}

	static double modulo(double number1, double number2) {
		return number1 % number2;
	}

	public static void main(String[] args) {
		System.out.println("Sum of " + number1 + " and " + number2 + " is "
				+ add(number1, number2));
		System.out.println("Difference of " + number1 + " and " + number2
				+ " is " + subtract(number1, number2));
		System.out.println("Product of " + number1 + " and " + number2 + " is "
				+ multiply(number1, number2));
		System.out.println("Quotient of " + number1 + " and " + number2
				+ " is " + divide(number1, number2));
		System.out.println("Remainder of " + number1 + " and " + number2
				+ " is " + modulo(number1, number2));
	}
}
