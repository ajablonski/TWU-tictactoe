package com.twu.tictactoe.strategies;

public interface Strategy {
    public boolean canBeUsed();

    public int getNextSquare();
}
