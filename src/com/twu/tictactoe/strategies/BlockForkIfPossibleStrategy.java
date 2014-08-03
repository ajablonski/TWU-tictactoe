package com.twu.tictactoe.strategies;

import com.twu.tictactoe.Board;

public class BlockForkIfPossibleStrategy implements Strategy {
    private final String opponentSymbol;
    private final Board board;

    public BlockForkIfPossibleStrategy(Board board, String opponentSymbol) {
        this.board = board;
        this.opponentSymbol = opponentSymbol;
    }

    @Override
    public boolean canBeUsed() {
        Strategy opponentStrategy = new ForkIfPossibleStrategy(board, opponentSymbol);
        return opponentStrategy.canBeUsed();
    }

    @Override
    public int getNextSquare() {
        Strategy opponentStrategy = new ForkIfPossibleStrategy(board, opponentSymbol);
        return opponentStrategy.getNextSquare();
    }
}
