package com.aurionpro.conditionalstatements;

import java.util.Scanner;

public class TreasureHuntApp {
	public static void main(String[] args) {
		Scanner scannner = new Scanner(System.in);
		
		System.out.println("Welcome to treasure Island");
		System.out.println("Enter your move - (Left/Right/Anything else): ");
		String userMoveFirst = scannner.nextLine();
		
		if(!userMoveFirst.equalsIgnoreCase("Left"))
		{
			System.out.println("Fall into a hole !! Game Over.");
		}
		else
		{
			System.out.println("Enter your next move - (Swim/Wait/Anything else): ");
			String userMoveSecond = scannner.nextLine();
			if(!userMoveSecond.equalsIgnoreCase("Wait"))
			{
				System.out.println("Atacked by trout !! Game Over.");
			}
			else
			{
				System.out.println("Enter which door - (Red/Blue/Yellow/Anything else): ");
				String doorChoice = scannner.nextLine();
				if(doorChoice.equalsIgnoreCase("Red"))
				{
					System.out.println("Burned by Fire !! Game Over.");
				}
				else if(doorChoice.equalsIgnoreCase("Blue"))
				{
					System.out.println("Eaten by beasts !! Game Over.");
				}
				else if(doorChoice.equalsIgnoreCase("Yellow"))
				{
					System.out.println("You Win !!");
				}
				else
				{
					System.out.println("Game Over.");
				}
			}
		}
		scannner.close();
	}
}
