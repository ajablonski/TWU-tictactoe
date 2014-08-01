package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void shouldPrintInitialBoard() {
        assertEquals(board.getBoardString(),
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
    }

    @Test
    public void shouldMarkSquareWithX() {
        assertEquals(board.getBoardString(),
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
        board.mark(2, "X");
        assertEquals(board.getBoardString(),
                "   | X |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
    }

    @Test
    public void shouldReturnTrueIfCellIsEmpty() {
        assertTrue(board.cellIsEmpty(1));
    }

    @Test
    public void shouldReturnFalseIfCellIsOccupied() {
        board.mark(2, "X");
        assertFalse(board.cellIsEmpty(2));
    }

    @Test
    public void shouldReturnTrueIfIsFull() {
        for (int i = 0; i < 9; i++) {
            board.mark(i + 1, "X");
        }
        assertTrue(board.isFull());
    }

    @Test
    public void shouldReturnFalseIfIsNotFull() {
        assertFalse(board.isFull());
    }

    @Test
    public void shouldGetCellSymbol() {
        board.mark(1, "X");
        assertEquals("X", board.getCell(1));
        assertEquals(" ", board.getCell(2));
    }


}