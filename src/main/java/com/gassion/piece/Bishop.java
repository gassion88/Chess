package com.gassion.piece;

import com.gassion.Color;
import com.gassion.Coordinates;

import java.util.Set;

public class Bishop extends Piece {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return null;
    }
}
