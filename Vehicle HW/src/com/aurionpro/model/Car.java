package com.aurionpro.model;

import java.util.Scanner;

public class Car implements Vehicle {
	private String fuelType;

	public Car() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter fuel type for Car (Petrol/Diesel): ");
		this.fuelType = scanner.nextLine();
		
	}

	@Override
	public void start() {
		System.out.println("Car is starting.");
	}

	@Override
	public void stop() {
		System.out.println("Car is stopping.");
	}

	@Override
	public String fuelType() {
		return fuelType;
	}
}
