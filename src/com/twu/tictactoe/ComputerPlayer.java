package com.twu.tictactoe;

import java.util.ArrayList;

public class ComputerPlayer extends Player {

    public ComputerPlayer(int playerNumber, String symbol) {
        super(null, null, playerNumber, symbol);
    }

    @Override
    public void takeTurn(Board board) {
        ArrayList<Strategy> strategies = new ArrayList<Strategy>();
        strategies.add(new WinIfPossibleStrategy(board, this));
        strategies.add(new NextAvailableSquareStrategy(board));
        for (Strategy strategy : strategies) {
            if (strategy.canBeUsed()) {
                board.mark(strategy.getNextSquare(), getSymbol());
                break;
            }
        }
    }
}
