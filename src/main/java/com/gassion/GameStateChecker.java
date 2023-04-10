package com.gassion;

import com.gassion.board.Board;

public abstract class GameStateChecker {
    public abstract GameState check(Board board, Color color);
}
