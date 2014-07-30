package com.twu.tictactoe;

import java.io.PrintStream;

public class Board {
    private PrintStream out;
    private String[] state = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

    public Board(PrintStream out) {
        this.out = out;
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

    public void mark(int i, String x) {
        state[i-1] = x;
    }

}
