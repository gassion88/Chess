package com.gassion;

import com.gassion.piece.Piece;

import java.util.Set;

public class Game {
    private final Board board;
    private final BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            boardConsoleRenderer.render(board);

            if (isWhiteToMove) {
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }

            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.WHITE : Color.BLACK, board
            );

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquares(board);
            Coordinates targerCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquare);

            board.movePiece(sourceCoordinates, targerCoordinates);

            isWhiteToMove = !isWhiteToMove;

        }
    }
}
