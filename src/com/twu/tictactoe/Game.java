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
        Player currentPlayer;
        String message = "Game is a draw";
        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = !board.isFull();

            currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.takeTurn(board);
            out.print(board.getBoardString());
            if (board.hasBeenWonBy(currentPlayer)) {
                message = "Player " + currentPlayer.getNumber() + " Wins!";
                keepGoing = false;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        out.println(message);
    }
}
