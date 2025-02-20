package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvenOddCheckerTest {

	EvenOddChecker checker;
	
	@BeforeEach
	void init()
	{
		checker = new EvenOddChecker();
	}
	
	@Test
	void testIsEven() {
		assertTrue(checker.isEven(10));
	}

}
