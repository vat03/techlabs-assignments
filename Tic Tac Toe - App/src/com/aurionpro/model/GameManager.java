package com.aurionpro.model;

import java.util.Scanner;

public class GameManager implements IGame {
	private GameController controller;

	public GameManager() {
		controller = new GameController();
	}

	@Override
	public void startGame() {
		controller.resetBoard();
		controller.printBoard();
	}

	@Override
	public boolean playTurn(int row, int col) {
		boolean success = controller.setValue(row, col);
		if (success) {
			controller.printBoard();
			if (controller.checkWinner()) {
				System.out.println("\nPlayer " + controller.getCurrentPlayer() + " wins!");
				return true;
			} else if (controller.isDraw()) {
				System.out.println("\nThe game is a draw!");
				return true;
			}
			controller.switchPlayer();
		}
		return false;
	}

	// Method to start the application
	public void runGame() {
		GameManager game = new GameManager();
		Scanner scanner = new Scanner(System.in);

		boolean playAgain;
		do {
			game.startGame();
			boolean gameOver = false;

			while (!gameOver) {
				System.out.println("\nPlayer " + controller.getCurrentPlayer() + "'s turn.");
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
	private boolean askPlayAgain(Scanner scanner) {
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