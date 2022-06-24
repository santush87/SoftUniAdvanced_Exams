package Date_28Jun2020;

import java.util.Scanner;

public class Snake_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[num][num];
        int myPosRow = -1;
        int myPosCol = -1;

        int eatenFood = 0;

        for (int row = 0; row < num; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int col = 0; col < num; col++) {
                if (matrix[row][col].equals("S")) {
                    myPosRow = row;
                    myPosCol = col;
                }
            }
        }

        while (true) {
            String command = scanner.nextLine();
            matrix[myPosRow][myPosCol] = ".";

            switch (command) {
                case "up":
                    myPosRow--;
                    break;
                case "down":
                    myPosRow++;
                    break;
                case "left":
                    myPosCol--;
                    break;
                case "right":
                    myPosCol++;
                    break;
            }
            if (myPosRow < 0 || myPosRow >= num ||
                    myPosCol < 0 || myPosCol >= num) {
                System.out.println("Game over!");
                break;
            }

            if (matrix[myPosRow][myPosCol].equals("*")) {
                eatenFood++;
            } else if (matrix[myPosRow][myPosCol].equals("B")) {
                matrix[myPosRow][myPosCol] = ".";
                for (int row = 0; row < num; row++) {
                    for (int col = 0; col < num; col++) {
                        if (matrix[row][col].equals("B")) {
                            myPosRow = row;
                            myPosCol = col;
                        }
                    }
                }
            }
            matrix[myPosRow][myPosCol] = "S";

            if (eatenFood >= 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }
        }

        System.out.println("Food eaten: " + eatenFood);
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
