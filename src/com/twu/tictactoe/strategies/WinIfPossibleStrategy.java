package com.twu.tictactoe.strategies;

import com.twu.tictactoe.Board;

public class WinIfPossibleStrategy implements Strategy {

    private final String playerSymbol;
    private final Board board;

    public WinIfPossibleStrategy(Board board, String playerSymbol) {
        this.board = board;
        this.playerSymbol = playerSymbol;
    }

    @Override
    public boolean canBeUsed() {
        return getNextSquare() != 0;
    }

    @Override
    public int getNextSquare() {
        int nextSquare = 0;

        for (int i = 1; i <= 9 && nextSquare == 0; i++) {
            if (board.cellIsEmpty(i)) {
                Board testBoard = new Board(board.getBoardState());
                testBoard.mark(i, playerSymbol);
                if (testBoard.hasBeenWonBy(playerSymbol)) {
                    nextSquare = i;
                }
            }
        }
        return nextSquare;
    }
}
