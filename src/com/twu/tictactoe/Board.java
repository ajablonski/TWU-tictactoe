package com.twu.tictactoe;

public class Board {
    private String[] state = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

    public Board() {
    }

    private String getRowString(int row) {
        int startCell = row * 3;
        return " " + this.state[startCell] + " | " +
                this.state[startCell + 1] + " | " +
                this.state[startCell + 2] + " \n";
    }

    public String getBoardString() {
        return  getRowString(0) + "-----------\n" + getRowString(1) + "-----------\n" + getRowString(2);
    }

    public void mark(int i, String x) {
        state[i - 1] = x;
    }

    public boolean cellIsEmpty(int i) {
        return state[i - 1].equals(" ");
    }
}
