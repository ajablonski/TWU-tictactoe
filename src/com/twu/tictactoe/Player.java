package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private BufferedReader in;
    private String symbol;
    private PrintStream out;
    private int playerNumber;

    public Player(BufferedReader in, PrintStream out, int playerNumber, String symbol) {
        this.in = in;
        this.symbol = symbol;
        this.out = out;
        this.playerNumber = playerNumber;
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
        out.print("Player " + playerNumber + ", choose a cell: ");
        int choice = getChoice();

        while (!board.cellIsEmpty(choice)) {
            out.println("Location not available");
            out.print("Choose a cell: ");
            choice = getChoice();
        }

        board.mark(choice, this.symbol);
    }

    public String getSymbol() {
        return this.symbol;
    }
}
