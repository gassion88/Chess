package com.gassion;

import com.gassion.board.Board;
import com.gassion.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardFactory().fromFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR ");

        Game game = new Game(board);
        game.gameLoop();
    }
}
