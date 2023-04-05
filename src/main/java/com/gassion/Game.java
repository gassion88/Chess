package com.gassion;

public class Game {
    private final Board board;
    private BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            boardConsoleRenderer.render(board);

            Coordinates coordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.WHITE : Color.BLACK, board
            );



            isWhiteToMove = !isWhiteToMove;

        }
    }
}
