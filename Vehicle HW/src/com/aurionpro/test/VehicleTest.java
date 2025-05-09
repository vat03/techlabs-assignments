package com.aurionpro.test;

import com.aurionpro.model.Bike;
import com.aurionpro.model.Car;
import com.aurionpro.model.Vehicle;

import java.util.Scanner;

public class VehicleTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of vehicles: ");
		int numVehicles = scanner.nextInt();
		scanner.nextLine();

		Vehicle[] vehicles = new Vehicle[numVehicles];

		int i = 0;
		while (i < numVehicles) {
			System.out.println("\nChoose vehicle type for vehicle " + (i + 1) + ":");
			System.out.println("1. Car");
			System.out.println("2. Bike");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				vehicles[i] = new Car();
				i++;
				break;
			case 2:
				vehicles[i] = new Bike();
				i++;
				break;
			default:
				System.out.println("Invalid choice! Please enter 1 for Car or 2 for Bike.");
				break;
			}
		}

		System.out.println("\nDisplaying Vehicle Details:");
		for (Vehicle vehicle : vehicles) {
			System.out.println("\nVehicle Type: " + vehicle.getClass().getSimpleName());
			vehicle.start();
			System.out.println("Fuel Type: " + vehicle.fuelType());
			vehicle.stop();
		}

		scanner.close();
	}
}
