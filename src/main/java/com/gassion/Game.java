package com.gassion;

import com.gassion.board.Board;
import com.gassion.board.BoardConsoleRenderer;
import com.gassion.board.Move;

import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board;
    private final BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();
    private final List<GameStateChecker> checkers = List.of(
            new StalemateGameStateChecker(),
            new CheckmateGameStateChecker()
    );

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        Color colorToMove = Color.WHITE;

        GameState gameState = determinateGameState(board, colorToMove);

        while (gameState == GameState.ONGOING) {
            boardConsoleRenderer.render(board);

            if (colorToMove == Color.WHITE) {
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }

            Move move = InputCoordinates.inputMove(board, colorToMove, boardConsoleRenderer);

            board.makeMove(move);

            colorToMove = colorToMove.oposite();

            gameState = determinateGameState(board, colorToMove);
        }

        boardConsoleRenderer.render(board);
        System.out.println("Game state: " + gameState);
    }

    private GameState determinateGameState(Board board, Color color) {
            for (GameStateChecker checker : checkers) {
                GameState gameState = checker.check(board, color);

                if (gameState != GameState.ONGOING) {
                    return gameState;
                }
            }

            return GameState.ONGOING;
    }
}
