package com.aurionpro.model;

public class GameController {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public GameController() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    public void resetBoard() {
        board = new Board();
        currentPlayer = playerX;
    }

    public boolean playMove(int row, int col) {
        if (board.setCell(row, col, currentPlayer.getSymbol())) {
            board.printBoard();
            return true;
        }
        System.out.println("Invalid move. Try again.");
        return false;
    }

    public boolean checkWinner() {
        return board.checkWin(currentPlayer.getSymbol());
    }

    public boolean isDraw() {
        return board.isFull();
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void printBoard() {
        board.printBoard();
    }
}
