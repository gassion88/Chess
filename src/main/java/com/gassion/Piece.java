package com.gassion;

abstract public class Piece {
    Color color;
    Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}
