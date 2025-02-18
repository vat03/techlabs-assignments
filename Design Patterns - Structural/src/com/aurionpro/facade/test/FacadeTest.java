package com.aurionpro.facade.test;

import java.util.Scanner;

import com.aurionpro.facade.model.HotelReception;

public class FacadeTest {

	public static void main(String[] args) {
		HotelReception receptionist = new HotelReception();

		Scanner scanner = new Scanner(System.in);

		System.out.println("What do you want to eat: ");
		String input = scanner.nextLine().toLowerCase();

		System.out.println();

		if (input.equals("indian"))
			receptionist.getIndianMenu();
		if (input.equals("italian"))
			receptionist.getItalianMenu();
		else
			System.out.println("Enter a valid choice");

		scanner.close();
	}
}
