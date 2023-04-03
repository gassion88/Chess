package com.gassion.piece;

import com.gassion.Color;
import com.gassion.Coordinates;

abstract public class Piece {
   public final Color color;
   public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}
