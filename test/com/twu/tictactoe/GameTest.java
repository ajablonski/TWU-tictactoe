package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {
    private Board fakeBoard;

    private PrintStream fakePrintStream;
    private Game testGame;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = mock(Player.class);
        when(player1.getSymbol()).thenReturn("X");
        player2 = mock(Player.class);
        when(player2.getSymbol()).thenReturn("O");
        fakePrintStream = mock(PrintStream.class);

        fakeBoard = mock(Board.class);
        when(fakeBoard.getBoardString()).thenReturn("Test");
        when(fakeBoard.cellIsEmpty(anyInt())).thenReturn(true);

        testGame = new Game(fakeBoard, player1, player2, fakePrintStream);
    }

    @Test
    public void gameShowsBoardOnStart() {
        testGame.start();
        verify(fakePrintStream, atLeastOnce()).print("Test");
    }

    @Test
    public void shouldAlternatePlayerTurnsOnStart() {
        testGame.start();
        verify(player1).takeTurn(fakeBoard);
        verify(player2).takeTurn(fakeBoard);
    }
}