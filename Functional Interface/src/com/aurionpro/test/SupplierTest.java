package com.aurionpro.test;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		Random random = new Random();
		
		Supplier<Integer> generateRandomNumber = () -> random.nextInt(1000);
		
		System.out.println("Random number generated is "+generateRandomNumber.get());
	}

}
