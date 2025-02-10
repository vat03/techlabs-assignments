package com.aurionpro.Day2HW;

import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int turn = 0;
		int turnScore = 0;
		int totalScore = 0;
		boolean gameOver = false;
		
		System.out.println("Welcome to the PIG Dice Game");
		
		do {
			if(turnScore == 0)
			{
				turn++;
				System.out.println();
				System.out.println("Turn "+turn+":");
			}
			
			System.out.println();
			
			System.out.print("Do you want to roll/hold (r/h): ");
			String userInput = scanner.nextLine();
			
			if(userInput.equalsIgnoreCase("r"))
			{
				int dieValue = random.nextInt(6) + 1;
				System.out.println("Die: "+dieValue);

				if(dieValue == 1)
				{
					turnScore = 0;
					System.out.println("You rolled 1 !! Turn Over. No Score for this turn.");
					System.out.println("Turn Score: "+turnScore);
					System.out.println("Total Score: "+totalScore);
				}
				else
				{
					turnScore = turnScore + dieValue;
					System.out.println("Turn Score: "+turnScore);
				}
			}
			else if(userInput.equalsIgnoreCase("h"))
			{
				totalScore = totalScore + turnScore;
				System.out.println("You held the die !! Turn over.");
				System.out.println("Turn Score: "+turnScore);
				System.out.println("Total Score: "+totalScore);
				turnScore = 0;
			}
			else
			{
				System.out.println("Please enter a valid choice !! ");
				System.out.println("R -> Roll & H -> Hold");
			}
			
			if(totalScore >= 20)
			{
				gameOver = true;
				System.out.println();
				System.out.println("Congratulations !! 20 points crossed\nYou finished the game by scoring "+totalScore+" points in "+turn+" turns.");
			}
			
		} while (gameOver == false);
		
		scanner.close();
	}
}
