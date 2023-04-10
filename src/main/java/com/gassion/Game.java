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

            Move move = InputCoordinates.inputMove(board, isWhiteToMove ? Color.WHITE : Color.BLACK, boardConsoleRenderer);

            board.movePiece(move);

            isWhiteToMove = !isWhiteToMove;

        }
    }
}
