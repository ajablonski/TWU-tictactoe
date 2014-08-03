package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {
    private Board fakeBoard;

    private PrintStream fakePrintStream;
    private Game testGame;
    private HumanPlayer player1;
    private HumanPlayer player2;

    @Before
    public void setUp() {
        player1 = mock(HumanPlayer.class);
        player2 = mock(HumanPlayer.class);
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
        when(fakeBoard.isFull()).thenReturn(false, false, false, true);
        when(fakeBoard.hasBeenWonBy(anyString())).thenReturn(false);
        testGame.start();
        verify(player1, times(2)).takeTurn(fakeBoard);
        verify(player2, times(1)).takeTurn(fakeBoard);
        verify(fakePrintStream).println("Game is a draw");
    }

    @Test
    public void shouldStopWhenPlayerHasWon() {
        when(player1.getSymbol()).thenReturn("X");
        when(fakeBoard.hasBeenWonBy(player1.getSymbol())).thenReturn(false, true);
        when(player1.getNumber()).thenReturn(1);
        testGame.start();
        verify(player1, times(1)).takeTurn(fakeBoard);
        verify(player2, never()).takeTurn(fakeBoard);

        verify(fakePrintStream).println("HumanPlayer 1 Wins!");
        verify(fakePrintStream, never()).println("Game is a draw");
    }
}