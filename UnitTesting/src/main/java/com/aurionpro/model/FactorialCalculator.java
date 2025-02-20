package com.aurionpro.model;

public class FactorialCalculator {

	public int factorial(int number) {
		int output = 1;

		for (int i = number; i > 0; i--) {
			output = output * i;
		}

		return output;
	}
}
