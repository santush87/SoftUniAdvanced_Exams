package Date_20Feb2021;

import java.util.Scanner;

public class Bomb_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String[] inputs = scanner.nextLine().split(",");

        String[][] matrix = new String[num][num];

        int myPosRow = -1;
        int myPosCol = -1;
        int bombs = 0;

        for (int row = 0; row < num; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
            for (int col = 0; col < num; col++) {
                if (matrix[row][col].equals("B")) {
                    bombs++;
                }
                if (matrix[row][col].equals("s")) {
                    myPosRow = row;
                    myPosCol = col;
                }
            }
        }

        boolean isEnd = false;
        while (!isEnd) {
            for (int i = 0; i < inputs.length; i++) {
                String command = inputs[i];
                matrix[myPosRow][myPosCol] = "+";
                switch (command) {
                    case "up":
                        myPosRow--;
                        if (myPosRow < 0) {
                            myPosRow = 0;
                        }
                        break;
                    case "down":
                        myPosRow++;
                        if (myPosRow >= num) {
                            myPosRow = num - 1;
                        }
                        break;
                    case "left":
                        myPosCol--;
                        if (myPosCol < 0) {
                            myPosCol = 0;
                        }
                        break;
                    case "right":
                        myPosCol++;
                        if (myPosCol >= num) {
                            myPosCol = num - 1;
                        }
                        break;
                }

                if (matrix[myPosRow][myPosCol].equals("B")) {
                    System.out.println("You found a bomb!");
                    matrix[myPosRow][myPosCol] = "+";
                    bombs--;
                    if (bombs == 0) {
                        System.out.println("Congratulations! You found all bombs!");
                        isEnd = true;
                        break;
                    }
                } else if (matrix[myPosRow][myPosCol].equals("e") || i == inputs.length - 1) {
                    System.out.printf("END! %d bombs left on the field", bombs);
                    isEnd = true;
                    break;
                }
            }
        }
    }
}
