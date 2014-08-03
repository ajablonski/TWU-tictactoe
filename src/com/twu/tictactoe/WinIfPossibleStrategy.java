package com.twu.tictactoe;

public class WinIfPossibleStrategy implements Strategy {

    private final Player player;
    private final Board board;

    public WinIfPossibleStrategy(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    @Override
    public boolean canBeUsed() {
        return getNextSquare() != 0;
    }

    @Override
    public int getNextSquare() {
        int nextSquare = 0;

        for (int i = 1; i <= 9 && nextSquare == 0; i++) {
            if (board.cellIsEmpty(i)) {
                Board testBoard = new Board(board.getBoardState());
                testBoard.mark(i, player.getSymbol());
                if (testBoard.hasBeenWonBy(player)) {
                    board.mark(i, player.getSymbol());
                    nextSquare = i;
                }
            }
        }
        return nextSquare;
    }
}
