package com.aurionpro.model;

public class Vehicle {
	private String brand;
	private String model;
	private double speed;
	
	public Vehicle()
	{
		
	}
	
	public Vehicle(String brand, String model, double speed) {
		this.brand = brand;
		this.model = model;
		this.speed = speed;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void accelerate(double increase)
	{
		speed = speed + increase;
	}
	
	public void brake(double decrease)
	{
		speed = speed - decrease;
	}
	
	public void displayInfo()
	{
		System.out.println("Brand: "+brand);
		System.out.println("Model: "+model);
		System.out.println("Speed: "+speed);
	}
}