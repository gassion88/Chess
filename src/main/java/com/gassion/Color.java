package com.gassion;

public enum Color {
    WHITE,
    BLACK;

    public Color oposite() {
        return this == WHITE ? BLACK : WHITE;
    }
}
