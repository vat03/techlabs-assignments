package com.aurionpro.test;

import com.aurionpro.model.GameManager;

import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		runGame();
	}

	// Method to start the application
	public static void runGame() {
		GameManager game = new GameManager();
		Scanner scanner = new Scanner(System.in);

		boolean playAgain;
		do {
			game.startGame();
			boolean gameOver = false;

			while (!gameOver) {
				System.out.println("\nPlayer " + game.getCurrentPlayer() + "'s turn.");
				System.out.print("Enter row (1-3): ");
				int row = scanner.nextInt() - 1;
				System.out.print("Enter column (1-3): ");
				int col = scanner.nextInt() - 1;
				scanner.nextLine();

				gameOver = game.playTurn(row, col);
			}

			playAgain = askPlayAgain(scanner);
		} while (playAgain);

		System.out.println("Thanks for playing!");
	}

	// Method to ask whether player wants to play again
	private static boolean askPlayAgain(Scanner scanner) {
		while (true) {
			System.out.print("\nDo you want to play again? (yes/no): ");
			String input = scanner.nextLine().toLowerCase();

			if (input.equals("yes")) {
				return true;
			}

			if (input.equals("no")) {
				return false;
			}

			System.out.println("Invalid choice. Please enter 'yes' to play again or 'no' to exit.");
		}
	}
}
