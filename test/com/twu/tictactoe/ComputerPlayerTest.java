package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ComputerPlayerTest {

    private ComputerPlayer player;
    private List<Strategy> strategies;
    private Strategy winIfPossibleStrategy;
    private Strategy nextAvailableSquareStrategy;
    private Board board;

    @Before
    public void setUp() {
        strategies = new ArrayList<Strategy>();
        winIfPossibleStrategy = mock(WinIfPossibleStrategy.class);
        strategies.add(winIfPossibleStrategy);
        nextAvailableSquareStrategy = mock(NextAvailableSquareStrategy.class);
        when(nextAvailableSquareStrategy.canBeUsed()).thenReturn(true);
        strategies.add(nextAvailableSquareStrategy);
        player = new ComputerPlayer(1, "X", strategies);
        board = mock(Board.class);
    }



    @Test
    public void shouldTakeEmptySquareIfCanWin() {
//        Board board = new Board(new String[]{
//                " ", " ", " ",
//                "X", " ", "X",
//                " ", " ", " "
//        });
        when(winIfPossibleStrategy.canBeUsed()).thenReturn(true);
        player.takeTurn(board);
        verify(winIfPossibleStrategy).getNextSquare();
        verify(strategies.get(0)).getNextSquare();
        verify(strategies.get(1), never()).getNextSquare();
    }

    @Test
    public void shouldTakeTurnBySelectingFirstAvailableCell() {
//        Board board = new Board(new String[]{
//                " ", " ", " ",
//                "X", " ", " ",
//                " ", " ", " "
//        });
        when(winIfPossibleStrategy.canBeUsed()).thenReturn(false);
        player.takeTurn(board);
        verify(winIfPossibleStrategy, never()).getNextSquare();
        verify(nextAvailableSquareStrategy).getNextSquare();
    }
}