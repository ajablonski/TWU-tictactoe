package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Game {
    private Board board;
    private BufferedReader in;
    private PrintStream out;

    public Game(Board board, BufferedReader in, PrintStream out) {
        this.board = board;
        this.in = in;
        this.out = out;
    }

    public void start() {
        out.print(board.getBoardString());
        takeTurn(1);
        out.print(board.getBoardString());
        takeTurn(2);
        out.print(board.getBoardString());
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

    public void takeTurn(int player) {
        int cell = getInput();
        while (!board.cellIsEmpty(cell)){
            out.println("Location not available");
            cell = getInput();
        }
        board.mark(cell, player == 1 ? "X" : "O");
    }
}
