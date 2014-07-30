package com.twu.tictactoe;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    @Test
    public void shouldPrintBoard() {
        PrintStream fakePrintStream = mock(PrintStream.class);
        Board b = new Board(fakePrintStream);
        b.showBoard();
        verify(fakePrintStream).print(
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n");
    }

}