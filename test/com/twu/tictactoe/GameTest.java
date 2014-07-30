package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class GameTest {

    private Board fakeBoard;
    private BufferedReader fakeBufferedReader;

    @Before
    public void setUp() {
        fakeBoard = mock(Board.class);
        fakeBufferedReader = mock(BufferedReader.class);
        try {
            when(fakeBufferedReader.readLine()).thenReturn("3", "7");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void gameShowsBoardOnStart() {
        Game g = new Game(fakeBoard, fakeBufferedReader);

        g.start();
        verify(fakeBoard, atLeastOnce()).showBoard();
    }

    @Test
    public void shouldGetInput() {
        Game g = new Game(fakeBoard, fakeBufferedReader);
        assertThat(g.getInput(), is(3));
    }

    @Test
    public void shouldMarkSpaceWhenPlayerTakesTurn() {
        Game g = new Game(fakeBoard, fakeBufferedReader);
        g.takeTurn(1);
        verify(fakeBoard).mark(3, "X");
    }

    @Test
    public void shouldAlternatePlayerTurnsOnStart() {
        Game g = new Game(fakeBoard, fakeBufferedReader);
        g.start();
        InOrder fnCalls = inOrder(fakeBoard);
        fnCalls.verify(fakeBoard).mark(3, "X");
        fnCalls.verify(fakeBoard).showBoard();
        fnCalls.verify(fakeBoard).mark(7, "O");
        fnCalls.verify(fakeBoard).showBoard();
    }
}