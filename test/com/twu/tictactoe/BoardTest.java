package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BoardTest {

    private PrintStream fakePrintStream;
    private BufferedReader fakeInputStream;

    @Before
    public void setUp() {
        fakePrintStream = mock(PrintStream.class);
        fakeInputStream = mock(BufferedReader.class);
    }

    @Test
    public void shouldPrintBoard() {
        Board b = new Board(fakePrintStream, fakeInputStream);
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
    public void shouldGetUserInput() {
        try {
            when(fakeInputStream.readLine()).thenReturn("2");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Board b = new Board(fakePrintStream, fakeInputStream);
        b.promptPlayer();
        b.showBoard();

        verify(fakePrintStream).print(
                "   | X |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );

    }

    @Test
    public void shouldMarkSquareWithX() {
        Board b = new Board(fakePrintStream, fakeInputStream);
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