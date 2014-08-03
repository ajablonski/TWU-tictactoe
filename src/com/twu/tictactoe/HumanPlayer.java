package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class HumanPlayer extends Player {

    private BufferedReader in;
    private PrintStream out;

    public HumanPlayer(BufferedReader in, PrintStream out, int playerNumber, String symbol) {
        super(playerNumber, symbol);
        this.out = out;
        this.in = in;
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
        out.print("Player " + getNumber() + ", choose a cell: ");
        int choice = getChoice();

        while (!board.cellIsEmpty(choice)) {
            out.println("Location not available");
            out.print("Choose a cell: ");
            choice = getChoice();
        }

        board.mark(choice, getSymbol());
    }
}
