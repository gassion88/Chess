package com.gassion;

import com.gassion.board.Board;
import com.gassion.board.BoardFactory;
import com.gassion.board.Move;
import com.gassion.piece.King;
import com.gassion.piece.Piece;

import java.util.List;
import java.util.Set;

public class CheckmateGameStateChecker extends GameStateChecker{

    @Override
    public GameState check(Board board, Color color) {
        Piece king = board.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();

        if (!board.isSquareAttackedByColor(king.coordinates, color.oposite())) {
            return GameState.ONGOING;
        }

        List<Piece> pieces = board.getPiecesByColor(color);

        for (Piece piece : pieces) {
           Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

            for (Coordinates availableMoveSquare : availableMoveSquares) {
               Board clone = new BoardFactory().copy(board);
               clone.makeMove(new Move(piece.coordinates, availableMoveSquare));

               Piece clonedKing = clone.getPiecesByColor(color).stream().filter(p -> p instanceof King).findFirst().get();

               if (!clone.isSquareAttackedByColor(clonedKing.coordinates, color.oposite())) {
                   return GameState.ONGOING;
               }
            }
        }

        if (color == Color.WHITE) {
            return GameState.CHECKMATE_TO_WHITE_KING;
        } else {
            return GameState.CHECKMATE_TO_BLACK_KING;
        }
    }
}
