package com.twu.tictactoe;

public abstract class Player {
    private final int playerNumber;
    private final String symbol;

    public Player(int playerNumber, String symbol) {
        this.symbol = symbol;
        this.playerNumber = playerNumber;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getNumber() {
        return this.playerNumber;
    }

    public abstract void takeTurn(Board board);
}
