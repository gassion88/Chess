package com.gassion;

import com.gassion.piece.Knight;
import com.gassion.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPeacesPositions();
        Board board = new BoardFactory().fromFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR ll");
       new BoardConsoleRenderer().render(board);
//
//        Piece piece = board.getPiece(new Coordinates( File.B, 1));
//        Set<Coordinates> coordinates = piece.getAvailableMoveSquares(board);

//        Game game = new Game(board);
//        game.gameLoop();

    }
}
