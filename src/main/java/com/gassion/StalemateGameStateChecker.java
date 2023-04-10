package com.gassion;

import com.gassion.board.Board;
import com.gassion.piece.Piece;

import java.util.List;
import java.util.Set;

public class StalemateGameStateChecker extends GameStateChecker{
    @Override
    public GameState check(Board board, Color color) {
        List<Piece> pieces = board.getPiecesByColor(color);

        for (Piece piece : pieces) {
           Set<Coordinates> pieceMoveSquare = piece.getAvailableMoveSquares(board);

           if (pieceMoveSquare.size() > 0) {
               return GameState.ONGOING;
           }
        }

        return GameState.STALEMATE;
    }
}
