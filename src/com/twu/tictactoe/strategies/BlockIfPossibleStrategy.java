package com.twu.tictactoe.strategies;

import com.twu.tictactoe.Board;

public class BlockIfPossibleStrategy implements Strategy {
    private Board board;
    private String opponentSymbol;

    public BlockIfPossibleStrategy(Board board, String opponentSymbol) {
        this.board = board;
        this.opponentSymbol = opponentSymbol;
    }

    @Override
    public boolean canBeUsed() {
        Strategy opponentStrategy = new WinIfPossibleStrategy(board, opponentSymbol);
        return opponentStrategy.canBeUsed();
    }

    @Override
    public int getNextSquare() {
        Strategy opponentStrategy = new WinIfPossibleStrategy(board, opponentSymbol);
        return opponentStrategy.getNextSquare();
    }
}
