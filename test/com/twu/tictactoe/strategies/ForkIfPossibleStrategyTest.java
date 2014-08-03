package com.twu.tictactoe.strategies;

import com.twu.tictactoe.Board;
import org.junit.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForkIfPossibleStrategyTest {
    Strategy forkIfPossibleStrategy;
    Board fakeBoard;

    @Before
    public void setUp() {
        fakeBoard = mock(Board.class);
        when(fakeBoard.getCell(anyInt())).thenReturn(" ");
        when(fakeBoard.cellIsEmpty(anyInt())).thenReturn(true);
        forkIfPossibleStrategy = new ForkIfPossibleStrategy(fakeBoard, "X");
    }

    @Test
    public void shouldReturnFalseIfTooFewSquares() {
        when(fakeBoard.getCell(3)).thenReturn("O");
        when(fakeBoard.getCell(4)).thenReturn("X");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", " ", "O", "X", " ", " ", " ", " ", " "});

        assertThat(forkIfPossibleStrategy.canBeUsed(), is(false));
    }

    @Test
    public void shouldReturnFalseIfForkNotPossible() {
        when(fakeBoard.getCell(4)).thenReturn("O");
        when(fakeBoard.cellIsEmpty(4)).thenReturn(false);
        when(fakeBoard.getCell(6)).thenReturn("X");
        when(fakeBoard.cellIsEmpty(6)).thenReturn(false);
        when(fakeBoard.getCell(7)).thenReturn("X");
        when(fakeBoard.cellIsEmpty(7)).thenReturn(false);
        when(fakeBoard.getCell(9)).thenReturn("O");
        when(fakeBoard.cellIsEmpty(9)).thenReturn(false);
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", " ", " ", "O", " ", "X", "X", " ", "O"});

        assertThat(forkIfPossibleStrategy.canBeUsed(), is(false));
    }

    @Test
    public void shouldReturnTrueIfForkPossible() {
        when(fakeBoard.getCell(3)).thenReturn("O");
        when(fakeBoard.getCell(4)).thenReturn("O");
        when(fakeBoard.getCell(5)).thenReturn("X");
        when(fakeBoard.getCell(7)).thenReturn("X");
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", " ", "O", "O", "X", " ", "X", " ", " "});

        assertThat(forkIfPossibleStrategy.canBeUsed(), is(true));
    }

    @Test
    public void shouldReturnCellNumberIfForkPossible() {
        when(fakeBoard.getCell(3)).thenReturn("O");
        when(fakeBoard.cellIsEmpty(3)).thenReturn(false);
        when(fakeBoard.getCell(4)).thenReturn("O");
        when(fakeBoard.cellIsEmpty(4)).thenReturn(false);
        when(fakeBoard.getCell(5)).thenReturn("X");
        when(fakeBoard.cellIsEmpty(5)).thenReturn(false);
        when(fakeBoard.getCell(7)).thenReturn("X");
        when(fakeBoard.cellIsEmpty(7)).thenReturn(false);
        when(fakeBoard.getBoardState()).thenReturn(new String[] {" ", " ", "O", "O", "X", " ", "X", " ", " "});

        assertThat(forkIfPossibleStrategy.getNextSquare(), is(8));
    }

}