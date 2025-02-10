package com.aurionpro.test;

import com.aurionpro.model.Car;
import com.aurionpro.model.Vehicle;
import com.aurionpro.model.ElectricCar;

public class VehicleTest {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("Brand1", "Model1", 30.4);
		Car car = new Car("MG", "Hector", 30.4, "Petrol", 4);
		ElectricCar electriccar = new ElectricCar("Tata", "NexonEv", 30.4, 4, 88, 120);
		
		System.out.println("Vehicle Object: ");
		vehicle.displayInfo();
		vehicle.accelerate(9.6);
		System.out.println("\nAfter Acceleration: \n");
		vehicle.displayInfo();
		vehicle.brake(5);
		System.out.println("\nAfter Braking: \n");
		vehicle.displayInfo();
		
		System.out.println();
		
		System.out.println("Car Object: ");
		car.displayInfo();
		car.accelerate(9.6);
		System.out.println("\nAfter Acceleration: \n");
		car.displayInfo();
		car.brake(5);
		System.out.println("\nAfter Braking: \n");
		car.displayInfo();
		
		System.out.println();
		
		System.out.println("Electric Car Object: ");
		electriccar.displayInfo();
		electriccar.accelerate(9.6);
		System.out.println("\nAfter Acceleration: \n");
		electriccar.displayInfo();
		electriccar.brake(5);
		System.out.println("\nAfter Braking: \n");
		electriccar.displayInfo();
	}

}
