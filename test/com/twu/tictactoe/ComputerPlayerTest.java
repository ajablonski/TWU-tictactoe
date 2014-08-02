package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ComputerPlayerTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldTakeTurnBySelectingFirstAvailableCell() {
        ComputerPlayer player = new ComputerPlayer(1, "X");
        Board fakeBoard = mock(Board.class);
        when(fakeBoard.cellIsEmpty(anyInt())).thenReturn(true);
        when(fakeBoard.cellIsEmpty(1)).thenReturn(false);
        player.takeTurn(fakeBoard);
        verify(fakeBoard).mark(2, "X");
    }
}