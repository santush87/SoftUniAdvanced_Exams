package Date_14Apr2021;

import java.util.Scanner;

public class CookingJourney_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[num][num];

        int myPosRow = -1;
        int myPosCol = -1;
        int collectedPrice = 0;

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
            int currRow = myPosRow;
            int currCol = myPosCol;

            String command = scanner.nextLine();
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

            matrix[currRow][currCol] = "-";

            if (myPosRow < 0 || myPosRow >= num ||
                    myPosCol < 0 || myPosCol >= num) {
                System.out.println("Bad news! You are out of the pastry shop.");
                System.out.println("Money: " + collectedPrice);
                break;
            }

            if (matrix[myPosRow][myPosCol].equals("P")) {
                matrix[myPosRow][myPosCol] = "-";
                for (int row = 0; row < num; row++) {
                    for (int col = 0; col < num; col++) {
                        if (matrix[row][col].equals("P")) {
                            myPosRow = row;
                            myPosCol = col;
                        }
                    }
                }
                matrix[myPosRow][myPosCol] = "S";
            } else if (matrix[myPosRow][myPosCol].equals("-")) {
                matrix[myPosRow][myPosCol] = "S";
            }else {
                collectedPrice += Integer.parseInt(matrix[myPosRow][myPosCol]);
                matrix[myPosRow][myPosCol] = "S";
            }

            if (collectedPrice >= 50){
                isEnd = true;
                System.out.println("Good news! You succeeded in collecting enough money!");
                System.out.println("Money: " + collectedPrice);
            }
        }

        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
