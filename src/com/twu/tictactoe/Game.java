package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;

public class Game {
    private Board board;
    private BufferedReader in;

    public Game(Board board, BufferedReader in) {
        this.board = board;
        this.in = in;
    }

    public void start() {
        board.showBoard();
        takeTurn(1);
        board.showBoard();
        takeTurn(2);
        board.showBoard();
    }

    public int getInput() {
        try {
            String choice = in.readLine();
            return Integer.parseInt(choice);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public void takeTurn(int i) {
        board.mark(getInput(), i == 1 ? "X" : "O");
    }
}
