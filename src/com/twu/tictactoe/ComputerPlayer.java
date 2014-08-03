package com.twu.tictactoe;

import com.twu.tictactoe.strategies.Strategy;

import java.util.List;

public class ComputerPlayer extends Player {

    private final List<Strategy> strategies;

    public ComputerPlayer(int playerNumber, String symbol, List<Strategy> strategies) {
        super(playerNumber, symbol);
        this.strategies = strategies;
    }

    public void takeTurn(Board board) {
        for (Strategy strategy : strategies) {
            if (strategy.canBeUsed()) {
                board.mark(strategy.getNextSquare(), getSymbol());
                break;
            }
        }
    }
}
