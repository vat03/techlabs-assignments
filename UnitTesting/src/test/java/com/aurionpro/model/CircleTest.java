package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class CircleTest {
	
	@Test
	void testCalculateRadius() {
		Circle circle = new Circle();
		assertEquals(3.14, circle.calculateRadius(1));
	}
}
