package com.twu.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Board board;
    private PrintStream out;


    public Game(Board board, Player player1, Player player2, PrintStream out) {
        this.board = board;
        this.players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        this.out = out;
    }

    public void start() {
        int currentPlayerIndex = 0;
        out.print(board.getBoardString());
        while (!board.isFull()) {
            players.get(currentPlayerIndex).takeTurn(board);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            out.print(board.getBoardString());
        }
        out.println("Game is a draw");
    }
}
