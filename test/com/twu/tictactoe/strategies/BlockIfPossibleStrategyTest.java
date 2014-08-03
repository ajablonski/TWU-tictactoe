package com.twu.tictactoe.strategies;

import com.twu.tictactoe.Board;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlockIfPossibleStrategyTest {
    Strategy strategy;
    Board fakeBoard;

    @Before
    public void setUp() {
        fakeBoard = mock(Board.class);
        when(fakeBoard.getCell(anyInt())).thenReturn(" ");
        when(fakeBoard.cellIsEmpty(anyInt())).thenReturn(true);
        strategy = new BlockIfPossibleStrategy(fakeBoard, "O");
    }

    @Test
    public void shouldBlockIfPossible() {
        when(fakeBoard.getCell(2)).thenReturn("O");
        when(fakeBoard.getCell(5)).thenReturn("O");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", "O", " ", " ", "O", " ", " ", " ", " "});

        assertThat(strategy.getNextSquare(), is(8));
    }

    @Test
    public void shouldReturnFalseIfNotUsable() {
        when(fakeBoard.getCell(2)).thenReturn("O");
        when(fakeBoard.getCell(5)).thenReturn("O");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", "O", " ", " ", "O", " ", " ", " ", " "});

        assertThat(strategy.canBeUsed(), is(true));
    }

    @Test
    public void shouldReturnTrueIfUsable() {
        when(fakeBoard.getCell(2)).thenReturn("O");
        when(fakeBoard.getCell(6)).thenReturn("O");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", "O", " ", " ", " ", "O", " ", " ", " "});

        assertThat(strategy.canBeUsed(), is(false));
    }
}