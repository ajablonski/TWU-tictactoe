package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private BufferedReader in;
    private String symbol;
    private PrintStream out;

    public Player(BufferedReader in, PrintStream out, String symbol) {
        this.in = in;
        this.symbol = symbol;
        this.out = out;
    }

    private int getChoice() {
        int choice = 0;
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }

    public void takeTurn(Board board) {
        int choice = getChoice();

        while (!board.cellIsEmpty(choice)) {
            out.println("Location not available");
            choice = getChoice();
        }

        board.mark(choice, this.symbol);
    }
}
