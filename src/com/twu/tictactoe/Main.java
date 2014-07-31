package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        Player player1 = new Player(new BufferedReader(new InputStreamReader(System.in)), "X");
        Player player2 = new Player(new BufferedReader(new InputStreamReader(System.in)), "O");

        Game g = new Game(b, player1, player2, System.out);
        g.start();
    }
}
