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
        player2 = mock(Player.class);
        fakePrintStream = mock(PrintStream.class);
        fakeBoard = mock(Board.class);

        testGame = new Game(fakeBoard, player1, player2, fakePrintStream);
    }

    @Test
    public void gameShowsBoardOnStart() {
        when(fakeBoard.getBoardString()).thenReturn("Test");
        when(fakeBoard.isFull()).thenReturn(true);
        testGame.start();
        verify(fakePrintStream).print("Test");
    }

    @Test
    public void shouldPlayUntilBoardIsFull() {
        when(fakeBoard.isFull()).thenReturn(false, false, true);
        when(fakeBoard.hasBeenWonBy(any(Player.class))).thenReturn(false);
        testGame.start();
        verify(player1, times(2)).takeTurn(fakeBoard);
        verify(player2, times(1)).takeTurn(fakeBoard);
        verify(fakePrintStream).println("Game is a draw");
    }

    @Test
    public void shouldStopWhenPlayerHasWon() {
        when(fakeBoard.hasBeenWonBy(player1)).thenReturn(true);
        when(player1.getNumber()).thenReturn(1);
        testGame.start();
        verify(player1, times(1)).takeTurn(fakeBoard);
        verify(player2, never()).takeTurn(fakeBoard);

        verify(fakePrintStream).println("Player 1 Wins!");
        verify(fakePrintStream, never()).println("Game is a draw");
    }
}