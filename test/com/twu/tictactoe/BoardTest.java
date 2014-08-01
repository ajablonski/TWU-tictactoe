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
    public void shouldReturnFalseIfCellIsOccupied() {
        Board b = new Board();
        b.mark(2, "X");
        assertFalse(b.cellIsEmpty(2));
    }

    @Test
    public void shouldReturnTrueIfIsFull() {
        Board b = new Board();
        for (int i = 0; i < 9; i++) {
            b.mark(i + 1, "X");
        }
        assertTrue(b.isFull());
    }

    @Test
    public void shouldReturnFalseIfIsNotFull() {
        Board b = new Board();
        assertFalse(b.isFull());
    }


}