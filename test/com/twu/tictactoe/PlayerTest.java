package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {

    private Player player;
    private BufferedReader fakeBufferedReader;
    private PrintStream fakePrintStream;

    @Before
    public void setUp() {
        fakeBufferedReader = mock(BufferedReader.class);
        fakePrintStream = mock(PrintStream.class);
        player = new Player(fakeBufferedReader, fakePrintStream, "X");
    }

    @Test
    public void shouldGetChoice() throws IOException {
        when(fakeBufferedReader.readLine()).thenReturn("2");

        assertThat(player.getChoice(), is(2));
    }

    @Test
    public void shouldGetSymbol() {
        assertThat(player.getSymbol(), is("X"));
    }

    @Test
    public void shouldTakeTurn() throws IOException {
        when(fakeBufferedReader.readLine()).thenReturn("2");
        Board board = mock(Board.class);
        when(board.cellIsEmpty(anyInt())).thenReturn(true);
        player.takeTurn(board);
        verify(board).mark(2, "X");
    }

    @Test
    public void shouldPromptAgainWhenInvalidLocationSelected() throws IOException {
        when(fakeBufferedReader.readLine()).thenReturn("2", "1");
        Board board = mock(Board.class);
        when(board.cellIsEmpty(1)).thenReturn(true);
        when(board.cellIsEmpty(2)).thenReturn(false);
        player.takeTurn(board);
        verify(board, never()).mark(2, "X");
        verify(board).mark(1, "X");
        verify(fakePrintStream).println("Location not available");
    }

}