package com.twu.tictactoe.strategies;

import com.twu.tictactoe.Board;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class WinIfPossibleStrategyTest {
    private Board fakeBoard;
    private Strategy winIfPossible;

    @Before
    public void setUp() {
        fakeBoard = mock(Board.class);
        when(fakeBoard.getCell(anyInt())).thenReturn(" ");
        when(fakeBoard.cellIsEmpty(anyInt())).thenReturn(true);
        winIfPossible = new WinIfPossibleStrategy(fakeBoard, "X");
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
        when(fakeBoard.getCell(2)).thenReturn("X");
        when(fakeBoard.getCell(6)).thenReturn("X");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", "X", " ", " ", " ", "X", " ", " ", " "});

        assertThat(winIfPossible.canBeUsed(), is(false));
    }

    @Test
    public void shouldGetNextSquare() {
        when(fakeBoard.getCell(2)).thenReturn("X");
        when(fakeBoard.getCell(5)).thenReturn("X");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", "X", " ", " ", "X", " ", " ", " ", " "});

        assertThat(winIfPossible.getNextSquare(), is(8));
    }

    @Test
    public void shouldNotMarkBoard() {
        when(fakeBoard.getCell(2)).thenReturn("X");
        when(fakeBoard.getCell(5)).thenReturn("X");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", "X", " ", " ", "X", " ", " ", " ", " "});

        winIfPossible.getNextSquare();
        verify(fakeBoard, never()).mark(anyInt(), anyString());
    }
}