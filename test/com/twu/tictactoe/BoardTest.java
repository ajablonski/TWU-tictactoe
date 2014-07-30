package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream fakePrintStream;

    @Before
    public void setUp() {
        fakePrintStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintBoard() {
        Board b = new Board(fakePrintStream);
        b.showBoard();
        verify(fakePrintStream).print(
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
    }

    @Test
    public void shouldMarkSquareWithX() {
        Board b = new Board(fakePrintStream);
        b.showBoard();
        verify(fakePrintStream).print(
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
        b.mark(2, "X");
        b.showBoard();
        verify(fakePrintStream).print(
                "   | X |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
    }
}