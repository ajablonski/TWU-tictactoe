package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;

public class Player {

    private BufferedReader in;
    private String symbol;

    public Player(BufferedReader in, String symbol) {
        this.in = in;
        this.symbol = symbol;
    }

    public int getChoice() {
        int choice = 0;
        try {
            choice = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
