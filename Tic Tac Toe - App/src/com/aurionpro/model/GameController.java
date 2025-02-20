package com.aurionpro.model;

class GameController {
	private char[][] board;
	private char currentPlayer;
	private static final int SIZE = 3;

	// Constructor
	public GameController() {
		board = new char[SIZE][SIZE];
		currentPlayer = 'X';
	}

	// Method to reset board
	public void resetBoard() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = '-';
			}
		}
		currentPlayer = 'X';
	}

	// Method to set the value of the current player
	public boolean setValue(int row, int col) {
		if (row < 0 || col < 0 || row >= SIZE || col >= SIZE || board[row][col] != '-') {
			System.out.println("Invalid move. Try again.");
			return false;
		}
		board[row][col] = currentPlayer;
		return true;
	}

	// Method to check for winner
	public boolean checkWinner() {
		// loop to check rows and columns
		for (int i = 0; i < SIZE; i++) {
			if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
					|| (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
				return true;
			}
		}

		// loop to check diagonal
		if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
				|| (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
			return true;
		}

		return false;
	}

	// Method to check for draw
	public boolean isDraw() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}

	// Method to switch player alternatively using ternary operator
	public void switchPlayer() {
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	}

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	// Method to print the board with updated values after each turn
	public void printBoard() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
