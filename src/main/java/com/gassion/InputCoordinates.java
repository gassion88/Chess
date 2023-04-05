package com.gassion;

import java.util.Scanner;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates input() {
        while (true) {
            System.out.println("Please enter coordinates ex: A1");

            String line = scanner.nextLine();
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

    public static void main(String[] args) {
        Coordinates coordinates = input();

        System.out.println("Coordinates :" + coordinates);
    }
}