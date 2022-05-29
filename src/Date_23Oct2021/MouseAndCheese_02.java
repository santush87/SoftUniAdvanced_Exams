package Date_23Oct2021;

import java.util.Scanner;

public class MouseAndCheese_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[number][number];
        int mouseRow = -1;
        int mouseCol = -1;
        int eatenCheese = 0;

        for (int row = 0; row < number; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < number; col++) {
                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        boolean isEnd = false;
        while (!isEnd) {
            String command = scanner.nextLine();
            int oldMouseRow = mouseRow;
            int oldMouseCol = mouseCol;
            switch (command) {
                case "up":
                    mouseRow--;
                    if (mouseRow >= 0) {
                        if (matrix[mouseRow][mouseCol] == 'B') {
                            matrix[mouseRow][mouseCol] = '-';
                            mouseRow--;
                        }
                    }
                    break;
                case "down":
                    mouseRow++;
                    if (mouseRow < number - 1) {
                        if (matrix[mouseRow][mouseCol] == 'B') {
                            matrix[mouseRow][mouseCol] = '-';
                            mouseRow++;
                        }
                    }
                    break;
                case "left":
                    mouseCol--;
                    if (mouseCol >= 0) {
                        if (matrix[mouseRow][mouseCol] == 'B') {
                            matrix[mouseRow][mouseCol] = '-';
                            mouseCol--;
                        }
                    }
                    break;
                case "right":
                    mouseCol++;
                    if (mouseCol < number - 1) {
                        if (matrix[mouseRow][mouseCol] == 'B') {
                            matrix[mouseRow][mouseCol] = '-';
                            mouseCol++;
                        }
                    }
                    break;
                case "end":
                    isEnd = true;
                    break;
            }
            matrix[oldMouseRow][oldMouseCol] = '-';
            if (mouseRow < 0 || mouseRow > number - 1 ||
                    mouseCol < 0 || mouseCol > number - 1) {
                System.out.println("Where is the mouse?");
                isEnd = true;
                break;
            }

            if (matrix[mouseRow][mouseCol] == 'c') {
                eatenCheese++;
                matrix[mouseRow][mouseCol] = 'M';
            } else {
                matrix[mouseRow][mouseCol] = 'M';
            }
        }

        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        }

        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
