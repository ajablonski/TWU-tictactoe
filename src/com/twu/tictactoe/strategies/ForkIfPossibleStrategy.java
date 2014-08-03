package com.twu.tictactoe.strategies;

import com.twu.tictactoe.Board;

public class ForkIfPossibleStrategy implements Strategy {
    private String playerSymbol;
    private Board board;

    public ForkIfPossibleStrategy(Board board, String playerSymbol) {
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

        for (int i = 1; i <=9 && nextSquare == 0; i++) {
            if (board.cellIsEmpty(i)) {
                Board testBoard = new Board(board.getBoardState());
                testBoard.mark(i, playerSymbol);
                Strategy canWin = new WinIfPossibleStrategy(testBoard, playerSymbol);
                if (canWin.canBeUsed()) {
                    testBoard.mark(canWin.getNextSquare(), "N");
                    Strategy canWinTwice = new WinIfPossibleStrategy(testBoard, playerSymbol);
                    if (canWinTwice.canBeUsed()) {
                        nextSquare = i;
                    }
                }
            }
        }

        return nextSquare;
    }
}
