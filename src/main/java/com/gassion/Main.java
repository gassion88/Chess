package com.gassion;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPeacesPositions();
        new BoardConsoleRenderer().render(board);


        System.out.println("123");
    }
}
