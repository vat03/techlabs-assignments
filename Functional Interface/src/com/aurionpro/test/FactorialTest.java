package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Factorial;

public class FactorialTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
		scanner.close();

		Factorial factorial = (num) -> {
			int output = 1;

			for (int i = 1; i <= num; i++) {
				output = output * i;
			}

			return output;
		};

		System.out.println(factorial.factorialValue(number));
	}
}
