package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Box;

public class BoxTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Box boxes[] = new Box[2];
		
		//for taking inputs		
		for(int i = 0; i < boxes.length; i++)
		{
			boxes[i] = new Box();
			takeInput(boxes[i], scanner);
			System.out.println();
		}
		
		System.out.println();
		
		//for output
		for (Box box : boxes) {
			displayDetails(box);
		}
	}

	public static void takeInput(Box box, Scanner scanner) {

		System.out.println("Enter the width: ");
		box.setWidth(scanner.nextDouble());
		System.out.println("Enter the Height: ");
		box.setHeight(scanner.nextDouble());
		System.out.println("Enter the Depth: ");
		box.setDepth(scanner.nextDouble());
	}

	public static void displayDetails(Box box) {
		System.out.println("Width: " + box.getWidth());
		System.out.println("Height: " + box.getHeight());
		System.out.println("Depth: " + box.getDepth());
		System.out.println();
	}
}
