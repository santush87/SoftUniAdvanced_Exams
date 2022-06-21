package Date_16Dec2020;

import java.util.Scanner;

public class Selling_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[num][num];

        int myPosRow = -1;
        int myPosCol = -1;
        int sum = 0;

        for (int row = 0; row < num; row++) {
            matrix[row] = scanner.nextLine().split("");
            for (int col = 0; col < num; col++) {
                if (matrix[row][col].equals("S")) {
                    myPosRow = row;
                    myPosCol = col;
                }
            }
        }

        boolean isEnd = false;
        while (!isEnd) {
            if (sum >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
            String command = scanner.nextLine();
            matrix[myPosRow][myPosCol] = "-";

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
                isEnd = true;
                System.out.println("Bad news, you are out of the bakery.");
            } else if (matrix[myPosRow][myPosCol].equals("O")) {
                matrix[myPosRow][myPosCol] = "-";
                for (int row = 0; row < num; row++) {
                    for (int col = 0; col < num; col++) {
                        if (matrix[row][col].equals("O")) {
                            myPosRow = row;
                            myPosCol = col;
                        }
                    }
                }
                matrix[myPosRow][myPosCol] = "S";
            } else if (matrix[myPosRow][myPosCol].equals("-")) {
                matrix[myPosRow][myPosCol] = "S";
            } else {
                sum += Integer.parseInt(matrix[myPosRow][myPosCol]);
                matrix[myPosRow][myPosCol] = "S";
            }
        }

        System.out.println("Money: " + sum);
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
