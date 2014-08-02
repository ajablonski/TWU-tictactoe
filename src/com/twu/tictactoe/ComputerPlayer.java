package com.twu.tictactoe;

public class ComputerPlayer extends Player {

    public ComputerPlayer(int playerNumber, String symbol) {
        super(null, null, playerNumber, symbol);
    }

    @Override
    public void takeTurn(Board board) {
        boolean hasTakenTurn = false;
        for (int i = 1; i <= 9 && !hasTakenTurn; i++) {
            if (board.cellIsEmpty(i)) {
                board.mark(i, getSymbol());
                hasTakenTurn = true;
            }
        }
    }
}
