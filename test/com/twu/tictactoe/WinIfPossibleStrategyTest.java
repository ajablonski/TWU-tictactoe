package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WinIfPossibleStrategyTest {
    private Board fakeBoard;
    private Player fakePlayer;
    private Strategy winIfPossible;

    @Before
    public void setUp() {
        fakeBoard = mock(Board.class);
        when(fakeBoard.getCell(anyInt())).thenReturn(" ");
        when(fakeBoard.cellIsEmpty(anyInt())).thenReturn(true);
        fakePlayer = mock(Player.class);
        when(fakePlayer.getSymbol()).thenReturn("X");
        winIfPossible = new WinIfPossibleStrategy(fakeBoard, fakePlayer);
    }

    @Test
    public void shouldReturnTrueIfUsable() {
        when(fakeBoard.getCell(2)).thenReturn("X");
        when(fakeBoard.getCell(5)).thenReturn("X");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", "X", " ", " ", "X", " ", " ", " ", " "});

        assertThat(winIfPossible.canBeUsed(), is(true));
    }

    @Test
    public void shouldReturnFalseIfNotUsable() {
        when(fakeBoard.getCell(anyInt())).thenReturn(" ");
        when(fakeBoard.getCell(2)).thenReturn("X");
        when(fakeBoard.getCell(6)).thenReturn("X");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", "X", " ", " ", " ", "X", " ", " ", " "});

        assertThat(winIfPossible.canBeUsed(), is(false));
    }

    @Test
    public void testGetNextSquare() {
        when(fakeBoard.getCell(anyInt())).thenReturn(" ");
        when(fakeBoard.getCell(2)).thenReturn("X");
        when(fakeBoard.getCell(5)).thenReturn("X");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", "X", " ", " ", "X", " ", " ", " ", " "});

        assertThat(winIfPossible.getNextSquare(), is(8));
    }
}