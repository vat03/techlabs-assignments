package com.aurionpro.model;

public class Board {
    private static final int SIZE = 3;
    private Cell[][] grid;

    public Board() {
        grid = new Cell[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public boolean setCell(int row, int col, char playerSymbol) {
        if (row < 0 || col < 0 || row >= SIZE || col >= SIZE || !grid[row][col].isEmpty()) {
            return false;
        }
        grid[row][col].setValue(playerSymbol);
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkWin(char playerSymbol) {
        // Loop to check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if ((grid[i][0].getValue() == playerSymbol && grid[i][1].getValue() == playerSymbol && grid[i][2].getValue() == playerSymbol) ||
                (grid[0][i].getValue() == playerSymbol && grid[1][i].getValue() == playerSymbol && grid[2][i].getValue() == playerSymbol)) {
                return true;
            }
        }

        // Check diagonals
        if ((grid[0][0].getValue() == playerSymbol && grid[1][1].getValue() == playerSymbol && grid[2][2].getValue() == playerSymbol) ||
            (grid[0][2].getValue() == playerSymbol && grid[1][1].getValue() == playerSymbol && grid[2][0].getValue() == playerSymbol)) {
            return true;
        }
        return false;
    }


    public void printBoard() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j].getValue() + " ");
            }
            System.out.println();
        }
    }
}
