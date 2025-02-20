package com.aurionpro.model;

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
    
    public char getCurrentPlayer() {
        return controller.getCurrentPlayer();
    }
}
