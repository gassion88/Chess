package com.gassion;

import com.gassion.piece.Pawn;
import com.gassion.piece.Piece;

public class BoardFactory {
    public Board fromFen(String fen) {
        Board board = new Board();
        String[] parts = fen.split(" ");
        String piecePositions = parts[0];

        String[] fenRows = piecePositions.split("/");

        for (int i = 0; i < fenRows.length; i++) {
            int rank = 8 - i;
            String row = fenRows[i];

            int fileIndex = 0;
            for (int j = 0; j < row.length(); j++) {
                char fenChar = row.charAt(j);

                if (Character.isDigit(fenChar)) {
                    fileIndex += Character.getNumericValue(fenChar);
                } else {
                    File file = File.values()[fileIndex];
                    Coordinates coordinates = new Coordinates(file, rank);

                    board.setPiece(coordinates, new Pawn(Color.WHITE, coordinates));
                    fileIndex++;
                }
            }
        }

        return board;
    }
}
