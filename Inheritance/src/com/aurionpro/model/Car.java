package com.aurionpro.model;

public class Car extends Vehicle {
	private String fuelType;
	private int numSeats;
	
	public Car()
	{
		
	}

	public Car(String brand, String model, double speed, String fuelType, int numSeats) {
		super(brand, model, speed);
		this.fuelType = fuelType;
		this.numSeats = numSeats;
	}

	public String getFuelType() {
		return fuelType;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Fueltype: " + fuelType);
		System.out.println("Number of Seats: " + numSeats);
	}
}
