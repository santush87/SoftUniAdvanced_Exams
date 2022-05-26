package Date_19Feb2022;

import java.util.Scanner;

public class PawnWars_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chess = new char[8][8];
        int blackRow = 0;
        int blackCol = 0;
        int whiteRow = 0;
        int whiteCol = 0;
        for (int row = 0; row < 8; row++) {
            chess[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < 8; col++) {
                if (chess[row][col] == 'b') {
                    blackRow = row;
                    blackCol = col;
                }
                if (chess[row][col] == 'w') {
                    whiteRow = row;
                    whiteCol = col;
                }
            }
        }
        String positionColBlack = findLetter(blackCol);
        int positionRowBlack = findRow(blackRow);
        String positionColWhite = findLetter(whiteCol);
        int positionRowWhite = findRow(whiteRow);

        int absDistance = Math.abs(blackCol - whiteCol);
        boolean gameOver = false;
        while (!gameOver) {
            if (absDistance > 1) {
                whiteRow--;
                if (whiteRow == 0) {
                    gameOver = true;
                    System.out.printf("Game over! White pawn is promoted to a queen at %s8.", positionColWhite);
                    break;
                }
                blackRow++;
                if (blackRow == 0) {
                    gameOver = true;
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s1.", positionColBlack);
                    break;
                }
            } else {
                int blackWhiteDist = Math.abs(blackRow - whiteRow);

                if (blackWhiteDist > 1) {
                    whiteRow--;
                    positionRowWhite = findRow(whiteRow);
                    blackWhiteDist = Math.abs(blackRow - whiteRow);
                    if (whiteRow == 0) {
                        gameOver = true;
                        System.out.printf("Game over! White pawn is promoted to a queen at %s8.", positionColWhite);
                        break;
                    }
                    if (blackWhiteDist > 1) {
                        blackRow++;
                        positionRowBlack = findRow(blackRow);
                        blackWhiteDist = Math.abs(blackRow - whiteRow);
                        if (blackRow == 0) {
                            gameOver = true;
                            System.out.printf("Game over! Black pawn is promoted to a queen at %s1.", positionColBlack);
                            break;
                        }
                    }else {
                        gameOver = true;
                        System.out.printf("Game over! Black capture on %s%d.", positionColWhite, positionRowWhite);
                        break;
                    }
                } else {
                    gameOver = true;
                    System.out.printf("Game over! White capture on %s%d.", positionColBlack, positionRowBlack);
                }
            }
        }
    }

    private static int findRow(int row) {
        switch (row) {
            case 0:
                return 8;
            case 1:
                return 7;
            case 2:
                return 6;
            case 3:
                return 5;
            case 4:
                return 4;
            case 5:
                return 3;
            case 6:
                return 2;
            case 7:
                return 1;
        }
        return 0;
    }

    private static String findLetter(int position) {
        switch (position) {
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";
            case 5:
                return "f";
            case 6:
                return "g";
            case 7:
                return "h";
        }
        return null;
    }
}
