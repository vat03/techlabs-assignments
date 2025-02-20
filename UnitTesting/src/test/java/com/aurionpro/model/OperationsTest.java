package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OperationsTest {

	Operations operations = new Operations();

	void testAddition() {
		int actual = operations.addition(10, 20);
		assertEquals(30, actual);
	}

	void testSubtraction() {
		int actual = operations.subtraction(10, 20);
		assertEquals(-10, actual);
	}

	void testMultiplication() {
		double actual = operations.multiplication(10, 20);
		assertEquals(200, actual);
	}

	@Test
	void testDivision() {
		assertThrows(ArithmeticException.class, () -> {
			operations.division(10, 0);
		});
	}
}
