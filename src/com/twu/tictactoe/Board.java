package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by alexjablonski on 7/30/14.
 */
public class Board {
    private PrintStream out;

    public Board(PrintStream out) {
        this.out = out;
    }

    public void showBoard() {
        out.print(
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n"
        );
    }
}
