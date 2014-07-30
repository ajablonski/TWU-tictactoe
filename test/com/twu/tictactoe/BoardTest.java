package com.twu.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void shouldPrintInitialBoard() {
        Board b = new Board();
        assertEquals(b.getBoardString(),
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
    }

    @Test
    public void shouldMarkSquareWithX() {
        Board b = new Board();
        assertEquals(b.getBoardString(),
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
        b.mark(2, "X");
        assertEquals(b.getBoardString(),
                "   | X |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
    }

    @Test
    public void shouldReturnTrueIfCellIsEmpty() {
        Board b = new Board();
        assertTrue(b.cellIsEmpty(1));
    }

    @Test
    public void shouldReturnFallIfCellIsOccupied() {
        Board b = new Board();
        b.mark(2, "X");
        assertFalse(b.cellIsEmpty(2));
    }


}