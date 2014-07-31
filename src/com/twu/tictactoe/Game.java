package com.twu.tictactoe;

import java.io.PrintStream;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private PrintStream out;


    public Game(Board board, Player player1, Player player2, PrintStream out) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.out = out;
    }

    public void start() {
        out.print(board.getBoardString());
        takeTurn(player1);
        out.print(board.getBoardString());
        takeTurn(player2);
        out.print(board.getBoardString());
    }

    public void takeTurn(Player player) {
        int cell = player.getChoice();
        while (!board.cellIsEmpty(cell)){
            out.println("Location not available");
            cell = player.getChoice();
        }
        board.mark(cell, player.getSymbol());
    }
}
