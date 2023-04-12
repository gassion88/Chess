package com.gassion;

import com.gassion.board.Board;
import com.gassion.board.BoardConsoleRenderer;
import com.gassion.board.BoardFactory;
import com.gassion.board.Move;
import com.gassion.piece.King;
import com.gassion.piece.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    private static Coordinates input() {
        while (true) {
            System.out.println("Please enter coordinates ex: A1");

            String line = scanner.nextLine();

            if (line.length() != 2) {
                System.out.println("Invalid coordinates format!");
                continue;
            }

            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if (line.length() != 2) {
                System.out.println("Invalid Format");
                continue;
            }

            if (!Character.isLetter(fileChar)) {
                System.out.println("Invalid format File");
                continue;
            }

            if (!Character.isDigit(rankChar)) {
                System.out.println("Invalid format Rank");
                continue;
            }

            int rank = Character.getNumericValue(rankChar);
            if (rank < 1 || rank > 8 ) {
                System.out.println("Rank must be 1-8");
                continue;
            }

            File file = File.fromChar(fileChar);
            if (file == null) {
                System.out.println("File must be A-H");
                continue;
            }

            return new Coordinates(file, rank);
        }
    }

    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board) {
        while (true) {
            System.out.println("Enter coordinates for piece move");

            Coordinates coordinates = input();
            if (board.isSquareEmpty(coordinates)) {
                System.out.println("You have chosen an empty square");
                continue;
            }

            Piece piece = board.getPiece(coordinates);
            if (piece.color != color) {
                System.out.println("Wrong Color");
                continue;
            }

            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
            if (availableMoveSquares.size() == 0) {
                System.out.println("Blocked figure");
                continue;
            }

            return coordinates;
        }
    }

    public static Move inputMove(Board board, Color color, BoardConsoleRenderer boardConsoleRenderer) {
        while (true) {
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    color, board
            );

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquares(board);
            boardConsoleRenderer.render(board, piece);
            Coordinates targerCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquare);

            Move move = new Move(sourceCoordinates, targerCoordinates);

            if (validateIfKingInCheckAfterMove(board, color, move)) {
                System.out.println("Your king is ander attack");
                continue;
            }

            return move;
        }
    }

    private static boolean validateIfKingInCheckAfterMove(Board board, Color color, Move move) {
        Board copyBoard = new BoardFactory().copy(board);
        copyBoard.makeMove(move);

        Piece king = copyBoard.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        return copyBoard.isSquareAttackedByColor(king.coordinates, color.oposite());
    }

    public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates) {
        while (true) {
            System.out.println("Enter move for selected piece");
            Coordinates input = input();

            if (!coordinates.contains(input)) {
                System.out.println("Non available square");
                continue;
            }

            return input;
        }
    }
}