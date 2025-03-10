package com.aurionpro.model;

public class ElectricCar extends Car
{
	private double batteryCapacity;
	private double chargingTime;

	public ElectricCar()
	{
		
	}
	
	public ElectricCar(String brand, String model, double speed, int numSeats, double batteryCapacity, double chargingTime) {
		super(brand, model, speed,"Electric", numSeats);
		this.batteryCapacity = batteryCapacity;
		this.chargingTime = chargingTime;
	}

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public double getChargingTime() {
		return chargingTime;
	}

	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public void setChargingTime(double chargingTime) {
		this.chargingTime = chargingTime;
	}
	
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Battery Capacity: "+batteryCapacity);
		System.out.println("Charging Time: "+chargingTime);
	}
}

