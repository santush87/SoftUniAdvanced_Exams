package Date_18Aug2021;

import java.util.Scanner;

public class FormulaOne_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[number][number];
        int playerRow = -1;
        int playerCol = -1;
        int finishRow = -1;
        int finishCol = -1;
        int bonusRow = -1;
        int bonusCol = -1;
        int trapRow = -1;
        int trapCol = -1;

        boolean isEnded = false;
        for (int row = 0; row < number; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < number; col++) {
                if (matrix[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
                if (matrix[row][col] == 'F') {
                    finishRow = row;
                    finishCol = col;
                }
                if (matrix[row][col] == 'B') {
                    bonusRow = row;
                    bonusCol = col;
                }
                if (matrix[row][col] == 'T') {
                    trapRow = row;
                    trapCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        boolean reached = false;
        if (countCommands > 0) {

            while (!isEnded) {
                int prevPlayerRow = playerRow;
                int prevPlayerCol = playerCol;
                switch (command) {
                    case "up":
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = number - 1;
                            break;
                        }
                        if (matrix[playerRow][playerCol] == 'B') {
                            playerRow--;
                        } else if (matrix[playerRow][playerCol] == 'T') {
                            playerRow++;
                        } else if (matrix[playerRow][playerCol] == 'F') {
                            System.out.printf("Well done, the player won first place!%n");
                            isEnded = true;
                            reached = true;
                        }
                        break;
                    case "down":
                        playerRow++;
                        if (playerRow >= number) {
                            playerRow = 0;
                            break;
                        }
                        if (matrix[playerRow][playerCol] == 'B') {
                            playerRow++;
                        } else if (matrix[playerRow][playerCol] == 'T') {
                            playerRow--;
                        } else if (matrix[playerRow][playerCol] == 'F') {
                            System.out.printf("Well done, the player won first place!%n");
                            isEnded = true;
                            reached = true;
                        }
                        break;
                    case "left":

                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = number - 1;
                            break;
                        }
                        if (matrix[playerRow][playerCol] == 'B') {
                            playerCol--;
                        } else if (matrix[playerRow][playerCol] == 'T') {
                            playerCol++;
                        } else if (matrix[playerRow][playerCol] == 'F') {
                            System.out.printf("Well done, the player won first place!%n");
                            isEnded = true;
                            reached = true;
                        }
                        break;
                    case "right":
                        playerCol++;
                        if (playerCol >= number) {
                            playerCol = 0;
                            break;
                        }
                        if (matrix[playerRow][playerCol] == 'B') {
                            playerCol++;
                        } else if (matrix[playerRow][playerCol] == 'T') {
                            playerCol--;
                        } else if (matrix[playerRow][playerCol] == 'F') {
                            System.out.printf("Well done, the player won first place!%n");
                            isEnded = true;
                            reached = true;
                        }
                        break;
                }
                matrix[prevPlayerRow][prevPlayerCol] = '.';
                matrix[playerRow][playerCol] = 'P';
                countCommands--;
                if (countCommands == 0) {
                    isEnded = true;
                } else {
                    command = scanner.nextLine();
                }
            }
        }
        if (!reached) {
            System.out.printf("Oh no, the player got lost on the track!%n");
        }
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
