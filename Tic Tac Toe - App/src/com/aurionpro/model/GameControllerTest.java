package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    private GameController controller;

    @BeforeEach
    void setUp() {
        controller = new GameController();
    }

    @Test
    void testSwitchPlayer() {
        controller.switchPlayer();
        assertEquals('O', controller.getCurrentPlayer().getSymbol());

        controller.switchPlayer();
        assertEquals('X', controller.getCurrentPlayer().getSymbol());
    }

    @Test
    void testValidMove() {
        assertTrue(controller.playMove(1, 1));
    }

    @Test
    void testInvalidMoveOccupiedCell() {
        controller.playMove(1, 1);
        assertFalse(controller.playMove(1, 1));
    }

    @Test
    void testInvalidMoveWithFaultyValue() {
        assertFalse(controller.playMove(-1, 0)); 
        assertFalse(controller.playMove(3, 3)); 
    }

    @Test
    void testWinCondition() {
        controller.playMove(0, 0);
        controller.switchPlayer();
        controller.playMove(1, 0);
        controller.switchPlayer();
        controller.playMove(0, 1);
        controller.switchPlayer();
        controller.playMove(1, 1);
        controller.switchPlayer();
        controller.playMove(0, 2);

        assertTrue(controller.checkWinner()); 
    }

    @Test
    void testDrawCondition() {
        controller.playMove(0, 0); 
        controller.switchPlayer();
        controller.playMove(0, 1); 
        controller.switchPlayer();
        controller.playMove(0, 2); 
        controller.switchPlayer();
        controller.playMove(1, 1);
        controller.switchPlayer();
        controller.playMove(1, 0); 
        controller.switchPlayer();
        controller.playMove(1, 2); 
        controller.switchPlayer();
        controller.playMove(2, 1); 
        controller.switchPlayer();
        controller.playMove(2, 0); 
        controller.switchPlayer();
        controller.playMove(2, 2); 

        assertTrue(controller.isDraw());
        assertFalse(controller.checkWinner());
    }
}
