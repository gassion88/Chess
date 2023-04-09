package com.gassion;

import com.gassion.piece.Knight;
import com.gassion.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPeacesPositions();
        Board board = new BoardFactory().fromFen("5r2/8/1b2p3/8/1n2KR2/2P5/8/8 - w");
 //      new BoardConsoleRenderer().render(board);
//
//        Piece piece = board.getPiece(new Coordinates( File.B, 1));
//        Set<Coordinates> coordinates = piece.getAvailableMoveSquares(board);

        Game game = new Game(board);
        game.gameLoop();

    }
}
