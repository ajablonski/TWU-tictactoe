package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Board {
    private PrintStream out;
    private BufferedReader in;
    private String[] state = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

    public Board(PrintStream out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    private String getRowString(int row) {
        int startCell = row * 3;
        return " " + this.state[startCell] + " | " +
                this.state[startCell + 1] + " | " +
                this.state[startCell + 2] + " \n";
    }

    public void showBoard() {
        out.print(
                getRowString(0) +
                "-----------\n" +
                getRowString(1) +
                "-----------\n" +
                getRowString(2)
        );
    }

    public void promptPlayer() {
        try {
            String choice = in.readLine();
            mark(Integer.parseInt(choice), "X");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mark(int i, String x) {
        state[i-1] = x;
    }
}
