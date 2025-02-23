package com.aurionpro.model;

import java.util.Scanner;

public class GameManager {
    private GameController controller;
    private Scanner scanner;

    public GameManager() {
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        controller = new GameController();
        controller.resetBoard();
        controller.printBoard();
    }

    public boolean playTurn(int row, int col) {
        boolean success = controller.playMove(row, col);
        if (success) {
            if (controller.checkWinner()) {
                System.out.println("\n" + controller.getCurrentPlayer().getPlayerName() + " wins!");
                return true;
            } else if (controller.isDraw()) {
                System.out.println("\nThe game is a draw!");
                return true;
            }
            controller.switchPlayer();
        }
        return false;
    }

    public void runGame() {
        boolean playAgain;
        do {
            startGame();
            boolean gameOver = false;

            while (!gameOver) {
                System.out.println("\n" + controller.getCurrentPlayer().getPlayerName() + "'s turn.");
                System.out.print("Enter row (1-3): ");
                int row = scanner.nextInt() - 1;
                System.out.print("Enter column (1-3): ");
                int col = scanner.nextInt() - 1;
                scanner.nextLine();

                gameOver = playTurn(row, col);
            }

            playAgain = askPlayAgain();
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    private boolean askPlayAgain() {
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
