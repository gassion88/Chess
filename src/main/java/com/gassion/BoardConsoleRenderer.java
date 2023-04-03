package com.gassion;

public class BoardConsoleRenderer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";
    public void render(Board board) {
        for (int rank = 8; rank > 0; rank--) {
            String line = "";

            for(File file: File.values()) {
                line += getStringForEmptySquare(new Coordinates(file, rank));
            }

            System.out.println(line);
        }
    }

    private String getStringForEmptySquare(Coordinates coordinates) {
        return colorizeSprite("    ", Color.WHITE, Board.isSquareDark(coordinates));
    }

    private String colorizeSprite(String sprite, Color piceColor, Boolean isDark) {
        String result = sprite;

        if (piceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND +result;
        }

        return result + ANSI_RESET;
    }
}
