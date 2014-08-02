package com.twu.tictactoe;

public class Board {
    private String[] state;

    public Board(String[] state) {
        this.state = state.clone();
    }

    public Board() {
        this.state = new String[] {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    }

    public String getBoardString() {
        return getRowString(0) + "-----------\n" + getRowString(1) + "-----------\n" + getRowString(2);
    }

    public void mark(int cellNumber, String symbol) {
        state[stateIndex(cellNumber)] = symbol;
    }

    public String getCell(int cellNumber) {
        return state[stateIndex(cellNumber)];
    }

    public boolean cellIsEmpty(int cellNumber) {
        return state[stateIndex(cellNumber)].equals(" ");
    }

    public boolean isFull() {
        boolean isFull = true;
        for (String cell : state) {
            if (cell.equals(" ")) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    private String getRowString(int row) {
        int startCell = row * 3;
        return " " + this.state[startCell] + " | " +
                this.state[startCell + 1] + " | " +
                this.state[startCell + 2] + " \n";
    }

    private int stateIndex(int cellNumber) {
        return cellNumber - 1;
    }

    public String[] getBoardState() {
        return state.clone();
    }
}
