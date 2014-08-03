package com.twu.tictactoe.strategies;

import com.twu.tictactoe.Board;

public class NextAvailableSquareStrategy implements Strategy {
    private final Board board;

    public NextAvailableSquareStrategy(Board board) {
        this.board = board;
    }

    @Override
    public boolean canBeUsed() {
        return !board.isFull();
    }

    @Override
    public int getNextSquare() {
        int nextSquare = 0;
        for (int i = 1; i <= 9 && nextSquare == 0; i++) {
            if (board.getCell(i).equals(" ")) {
                nextSquare = i;
            }
        }
        return nextSquare;
    }
}
