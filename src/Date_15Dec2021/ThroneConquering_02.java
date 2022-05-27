package Date_15Dec2021;

import java.util.Scanner;

public class ThroneConquering_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int lines = Integer.parseInt(scanner.nextLine());
        int parisRow = -1;
        int parisCol = -1;

        char[][] matrix = new char[lines][];

        for (int row = 0; row < lines; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        boolean endGame = false;
        while (!endGame) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);
            matrix[spartanRow][spartanCol] = 'S';

            int prevRow = parisRow;
            int prevCol = parisCol;

            switch (command) {
                case "up":
                    parisRow--;
                    break;
                case "down":
                    parisRow++;
                    break;
                case "left":
                    parisCol--;
                    break;
                case "right":
                    parisCol++;
                    break;
            }
            energy--;

            if (parisRow < 0 || parisRow > matrix.length - 1 ||
                    parisCol < 0 || parisCol > matrix[0].length) {
                parisRow = prevRow;
                parisCol = prevCol;
            } else {
                matrix[prevRow][prevCol] = '-';

                if (matrix[parisRow][parisCol] == 'H') {
                    matrix[parisRow][parisCol] = '-';
                    System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                    print(matrix);
                    endGame = true;
                } else if (matrix[parisRow][parisCol] == 'S') {
                    energy -= 2;
                    if (energy <= 0) {
                        matrix[parisRow][parisCol] = 'X';
                        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                        print(matrix);
                        endGame = true;
                    } else {
                        matrix[parisRow][parisCol] = 'P';
                    }
                } else {
                    if (energy <= 0) {
                        matrix[parisRow][parisCol] = 'X';
                        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                        print(matrix);
                        endGame = true;
                    }else {
                        matrix[parisRow][parisCol] = 'P';
                    }
                }
            }
        }
    }

    private static void print(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
