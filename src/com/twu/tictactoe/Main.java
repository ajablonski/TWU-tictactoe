package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player(new BufferedReader(new InputStreamReader(System.in)), System.out, 1, "X");
        ArrayList<Strategy> strategies = new ArrayList<Strategy>();
        strategies.add(new WinIfPossibleStrategy(board, "O"));
        strategies.add(new BlockIfPossibleStrategy(board, "X"));
        strategies.add(new NextAvailableSquareStrategy(board));
        Player player2 = new ComputerPlayer(2, "O", strategies);

        Game game = new Game(board, player1, player2, System.out);
        game.start();
    }
}
