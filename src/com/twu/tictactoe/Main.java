package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        Player player1 = new Player(new BufferedReader(new InputStreamReader(System.in)), System.out, 1, "X");
        Player player2 = new ComputerPlayer(2, "O");

        Game g = new Game(b, player1, player2, System.out);
        g.start();
    }
}
