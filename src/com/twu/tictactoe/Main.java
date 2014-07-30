package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Board b = new Board(System.out);
        Game g = new Game(b, new BufferedReader(new InputStreamReader(System.in)));
        g.start();
    }
}
