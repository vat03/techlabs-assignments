package com.aurionpro.test;

import java.util.Scanner;
import java.util.function.BiConsumer;

public class BiConsumerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		BiConsumer<Integer, Integer> addition = (number1, number2) -> {
			System.out.println("Addition of " + number1 + " and " + number2 + " is " + (number1 + number2));
		};

		System.out.print("Enter number 1: ");
		int number1 = scanner.nextInt();
		System.out.println();
		System.out.println("Enter number 2: ");
		int number2 = scanner.nextInt();

		addition.accept(number1, number2);

		scanner.close();
	}
}
