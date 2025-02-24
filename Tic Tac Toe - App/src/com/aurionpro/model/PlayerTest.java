package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testPlayerSymbol() {
        Player playerX = new Player('X');
        Player playerO = new Player('O');

        assertEquals('X', playerX.getSymbol());
        assertEquals('O', playerO.getSymbol());
    }

    @Test
    void testPlayerName() {
        Player playerX = new Player('X');
        assertEquals("Player X", playerX.getPlayerName());
    }
}
