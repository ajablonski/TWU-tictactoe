package com.twu.tictactoe;

public interface Strategy {
    public boolean canBeUsed();

    public int getNextSquare();
}
