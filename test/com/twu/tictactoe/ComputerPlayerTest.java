package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ComputerPlayerTest {

    private ComputerPlayer player;

    @Before
    public void setUp() {
        player = new ComputerPlayer(1, "X");
    }

    @Test
    public void shouldTakeEmptySquareIfCanWin() {
        Board board = new Board(new String[]{
                " ", " ", " ",
                "X", " ", "X",
                " ", " ", " "
        });
        player.takeTurn(board);
        assertThat(board.getCell(5), is("X"));
    }

    @Test
    public void shouldTakeTurnBySelectingFirstAvailableCell() {
        Board board = new Board(new String[]{
                " ", " ", " ",
                "X", " ", " ",
                " ", " ", " "
        });
        player.takeTurn(board);
        assertThat(board.getCell(1), is("X"));
    }
}