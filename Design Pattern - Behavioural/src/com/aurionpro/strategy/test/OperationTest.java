package com.aurionpro.strategy.test;

import java.util.Scanner;

import com.aurionpro.strategy.model.AddOperation;
import com.aurionpro.strategy.model.MultiplyOperation;
import com.aurionpro.strategy.model.OperationStrategy;

public class OperationTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number 1: ");
		int number1 = scanner.nextInt();

		System.out.print("Enter number 2: ");
		int number2 = scanner.nextInt();

		OperationStrategy strategy = new OperationStrategy(new AddOperation());
		System.out.print("\nAddition operation of " + number1 + " and " + number2 + " is: "
				+ strategy.doOperation(number1, number2));

		System.out.println();

		strategy.setOperation(new MultiplyOperation());
		System.out.print("\nMultiplication operation of " + number1 + " and " + number2 + " is: "
				+ strategy.doOperation(number1, number2));

		scanner.close();
	}

}
