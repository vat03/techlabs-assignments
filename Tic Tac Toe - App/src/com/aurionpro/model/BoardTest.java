package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testInitialBoardIsEmpty() {
        assertTrue(board.isFull() == false);
    }

    @Test
    void testSetCellInvalidMove() {
        board.setCell(1, 1, 'X');
        assertFalse(board.setCell(1, 1, 'O'));
    }

    @Test
    void testSetCellInvalidMoveWithFaultyValue() {
        assertFalse(board.setCell(-1, 1, 'X'));
        assertFalse(board.setCell(3, 3, 'O'));
    }

    @Test
    void testCheckWinRow() {
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'X');
        board.setCell(0, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testCheckWinColumn() {
        board.setCell(0, 1, 'O');
        board.setCell(1, 1, 'O');
        board.setCell(2, 1, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    void testCheckWinDiagonal() {
        board.setCell(0, 0, 'X');
        board.setCell(1, 1, 'X');
        board.setCell(2, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testCheckDraw() {
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'O');
        board.setCell(0, 2, 'X');
        board.setCell(1, 0, 'X');
        board.setCell(1, 1, 'O');
        board.setCell(1, 2, 'O');
        board.setCell(2, 0, 'O');
        board.setCell(2, 1, 'X');
        board.setCell(2, 2, 'X');
        assertTrue(board.isFull());
    }
}
