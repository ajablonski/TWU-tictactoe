package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class GameTest {

    private Board board;
    private Board fakeBoard;
    private BufferedReader fakeBufferedReader;
    private PrintStream fakePrintStream;

    @Before
    public void setUp() {
        fakeBufferedReader = mock(BufferedReader.class);
        fakePrintStream = mock(PrintStream.class);
        board = new Board();

        fakeBoard = mock(Board.class);
        when(fakeBoard.cellIsEmpty(anyInt())).thenReturn(true);

        try {
            when(fakeBufferedReader.readLine()).thenReturn("3", "7");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void gameShowsBoardOnStart() {
        Game testGame = new Game(board, fakeBufferedReader, fakePrintStream);
        testGame.start();

        verify(fakePrintStream).print(board.getBoardString());
    }

    @Test
    public void shouldGetInput() {
        Game testGame = new Game(board, fakeBufferedReader, fakePrintStream);

        assertThat(testGame.getInput(), is(3));
    }

    @Test
    public void shouldMarkSpaceWhenPlayerTakesTurn() {
        Game testGame = new Game(fakeBoard, fakeBufferedReader, fakePrintStream);

        testGame.takeTurn(1);
        verify(fakeBoard).mark(3, "X");
    }

    @Test
    public void shouldAlternatePlayerTurnsOnStart() {
        Game testGame = new Game(fakeBoard, fakeBufferedReader, fakePrintStream);

        testGame.start();
        InOrder fnCalls = inOrder(fakeBoard);

        fnCalls.verify(fakeBoard).getBoardString();
        fnCalls.verify(fakeBoard).mark(3, "X");
        fnCalls.verify(fakeBoard).getBoardString();
        fnCalls.verify(fakeBoard).mark(7, "O");
        fnCalls.verify(fakeBoard).getBoardString();
    }

    @Test
    public void shouldPromptAgainWhenInvalidLocationSelected() {
        Game testGame = new Game(fakeBoard, fakeBufferedReader, fakePrintStream);
        try {
            when(fakeBufferedReader.readLine()).thenReturn("1", "1", "7");
        } catch (IOException e) {
            e.printStackTrace();
        }
        when(fakeBoard.cellIsEmpty(1)).thenReturn(true, false);
        testGame.takeTurn(1);
        verify(fakeBoard).mark(1, "X");
        testGame.takeTurn(2);
        verify(fakePrintStream).println("Location not available");
        verify(fakeBoard).mark(7, "O");
    }
}