package com.gassion;

import com.gassion.board.Board;
import com.gassion.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPeacesPositions();
        Board board = new BoardFactory().fromFen("8/8/4p3/4N3/r3K3/8/8/8 - w");
 //      new BoardConsoleRenderer().render(board);
//
//        Piece piece = board.getPiece(new Coordinates( File.B, 1));
//        Set<Coordinates> coordinates = piece.getAvailableMoveSquares(board);

        Game game = new Game(board);
        game.gameLoop();

    }
}
