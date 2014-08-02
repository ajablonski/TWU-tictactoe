package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
    public void shouldPrintMarkedBoard() {
        Board board = new Board(new String[]
                {" ", "X", " ",
                        " ", " ", " ",
                        " ", " ", " "});
        assertEquals(board.getBoardString(),
                "   | X |   \n" +
                        "-----------\n" +
                        "   |   |   \n" +
                        "-----------\n" +
                        "   |   |   \n"
        );
    }

    @Test
    public void shouldMarkSquareWithX() {
        board.mark(2, "X");
        assertThat(board.getBoardState(), is(new String[]{" ", "X", " ", " ", " ", " ", " ", " ", " "}));
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
        Board board = new Board(new String[]{
                "X", "X", "O",
                "O", "O", "X",
                "X", "O", "X"
        });
        assertTrue(board.isFull());
    }

    @Test
    public void shouldReturnFalseIfIsNotFull() {
        assertFalse(board.isFull());
    }

    @Test
    public void shouldGetEmptyCellGivenEmptyBoard() {
        assertThat(board.getCell(1), is(" "));
    }

    @Test
    public void shouldGetCellSymbolWhenMarked() {
        board.mark(1, "X");
        assertEquals("X", board.getCell(1));
    }


}