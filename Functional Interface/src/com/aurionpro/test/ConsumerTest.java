package com.aurionpro.test;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Consumer<Double> calculateArea = (radius) ->
		{
			System.out.println("Area of circle with radius "+radius+" is "+(3.14*radius*radius));
		};
		
		
		System.out.println("Enter the radius of the circle: ");
		double radius = scanner.nextDouble();
		calculateArea.accept(radius);
		
		scanner.close();
	}
}
