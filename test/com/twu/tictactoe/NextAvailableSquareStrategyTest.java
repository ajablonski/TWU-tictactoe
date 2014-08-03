package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NextAvailableSquareStrategyTest {

    private NextAvailableSquareStrategy nextAvailableSquareStrategy;
    private Board fakeBoard;

    @Before
    public void setUp() {
        fakeBoard = mock(Board.class);

        this.nextAvailableSquareStrategy = new NextAvailableSquareStrategy(fakeBoard);
    }

    @Test
    public void shouldSayThatStrategyCanBeUsed() {
        when(fakeBoard.isFull()).thenReturn(false);

        assertThat(nextAvailableSquareStrategy.canBeUsed(), is(true));
    }

    @Test
    public void shouldSayThatSquareIsNextSquare() {
        when(fakeBoard.cellIsEmpty(anyInt())).thenReturn(false);
        when(fakeBoard.cellIsEmpty(5)).thenReturn(true);
        when(fakeBoard.getCell(anyInt())).thenReturn("X");
        when(fakeBoard.getCell(5)).thenReturn(" ");

        assertThat(nextAvailableSquareStrategy.getNextSquare(), is(5));
    }
}